package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import jdbc.day1.OracleConnectionUtil;


public class StoredProcTest {
    
    public static void main(String[] args) {
        //exec_max_customer();
        exec_money_of_day();
    }
    

    private static void exec_money_of_day(){
        System.out.println("고객ID 와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.println("고객 ID 입력_");
        String customid = System.console().readLine();

        System.out.println("구매 날짜 입력_");
        String buydate = System.console().readLine();

        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call money_of_day(?,?,?) }";
        try (CallableStatement cstmt = connection.prepareCall(sql)){

            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 타입 설정 1)타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();  //프로시저 실행
            //OUT 매개변수 2) 결과값 가져오기 : getXXX

            String result = String.format("%s 고객님이 %s 에 구매한 총 구매금액 : %,8d",customid,buydate,cstmt.getInt(3));
            System.out.println(result);
            
        } catch (SQLException e) {
            System.out.println("money_of_dayax exe 프로시저 실행 예외 : " + e.getMessage());
    }
}

    private static void exec_max_customer(){
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call max_custom(?,?)}";              //프로시저 sql 형식 "{call 프로시저이름(?,?,...)}" 매개변수는 정의된 개수만큼 ? 나열
        try(
            CallableStatement cstmt = connection.prepareCall(sql)   
            //프로시저 실행 및 관리 인터페이스 CallableStatement 의 매소드 prepareCall 로 객체 생성하기
        ){
            //프로시저 실행 결과 OUT 파라미터 1번 인덱스의  타입 지정하기 - 고객이름
            cstmt.registerOutParameter(1, Types.VARCHAR);

            //프로시저 실행 결과 OUT 파라미터 2번 인덱스의  타입 지정하기 - 고객나이
            cstmt.registerOutParameter(2, Types.NUMERIC);
            cstmt.executeUpdate();  //프로시저 실행
            //프로시저 실행 결과 OUT 파라미터 값은 cstmt 객체에 저장됩니다.
            //쇼핑몰 관리자(일반 사용자 원하는 정보)
            System.out.println("구매 수량이 가장 많은 고객 정보 조회한 결과 입니다.");
            //인덱스 1번 OUT 실행 결과값 가져오기
            System.out.println("고객 이름 : " + cstmt.getString(1));
            System.out.println("고객 나이 : " + cstmt.getInt(2));
        }catch(SQLException e){
            System.out.println("max custom 프로시저 실행 예외 : " + e.getMessage());
        }
    }
}

