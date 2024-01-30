package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

public class TblBuyDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME = "C##idev";
    private static final String  PASSWORD= "1234";
    
      private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
     public void insert(BuyVo vo){
        String sql = "insert into tbl_buy(buy_IDX,customid, pcode,quantity,buy_date)\n" +
                      "values (buy_pk_seq.nextval,?,?,?,sysdate)";   //할일 : INSERT
        try(//auto close
            Connection connection = getConnection();                    //1) 서버와의 연결
            PreparedStatement pstmt = connection.prepareStatement(sql);     //2) 연결된 서버로 실행할 SQL전달. 서버가 SQL컴파일
        ){

            //할일 : 2) 매개변수 바인딩

            //매개변수 바인딩
            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2,vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());

            pstmt.executeQuery();                                       //3) 연결된 서버에 실행 요청
        }catch (SQLException e){
            System.out.println("insert 실행 예외 발생 : " + e.getMessage());
        }//finally 없음
        
    }

    public void delete(int buy_IDX){
        String sql = "DELETE FROM TBL_buy tb WHERE buy_IDX = ?";

        try (   //auto close
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            //매개변수 바인딩
            pstmt.setInt(1, buy_IDX);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : "+ e.getMessage());
        }//finally 없음
    }


    public void update(BuyVo vo){
        String sql = "UPDATE TBL_buy SET QUANTITY = ? WHERE buy_IDX = ?";

        try (   //auto close
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            //매개변수 바인딩
            pstmt.setInt(1, vo.getQuantity());
            pstmt.setInt(2, vo.getBuy_IDX());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : "+ e.getMessage());
        }//finally 없음
    }

    //mypage
    public List<CustomerBuyVo> selectCustomerBuyList(String customerid){
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX,tb.PCODE,PNAME,PRICE,QUANTITY,BUY_DATE \r\n" +
                            "FROM TBL_BUY tb\r\n" +
                            "JOIN TBL_PRODUCT tp\r\n"+
                            "ON tb.PCODE = tp.PCODE\r\n"+
                            "WHERE tb.CUSTOMID = ?\r\n"+
                            "ORDER BY BUY_DATE DESC";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            pstmt.setString(1, customerid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { 
                list.add(new CustomerBuyVo(rs.getInt(1),
                                           rs.getString(2), 
                                           rs.getString(3),
                                           rs.getInt(4),
                                           rs.getInt(5),
                                           rs.getTimestamp(6)));
                                            
                              }
        }
        catch(Exception e) {
            System.out.println("selectCustomerBuyList 예외 발생 : " + e.getMessage());
        }
        return list;
    }

}