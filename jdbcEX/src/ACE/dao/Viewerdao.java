package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ACE.vo.MovieReserveVo;


public class Viewerdao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int checkId(String viewerid){
        String sql = "SELECT CUSTOM_ID \r\n" + 
                "FROM TBL_VIEWER tv\r\n" + 
                "WHERE CUSTOM_ID = ?";
        int result=0;
        try (   
            Connection connection = getConnection();   
            PreparedStatement pstmt = connection.prepareStatement(sql); 
        ){

            pstmt.setString(1, viewerid);
            result=pstmt.executeUpdate();  
                
        } catch (SQLException e) {
            System.out.println("checkId 실행 예외 발생 : "+ e.getMessage());
        }
        return result;
    }

    public MovieReserveVo selAll(String id){
        String sql = "SELECT * \r\n" + 
                    "FROM TBL_RESERVE "+
                    "WHERE CUSTOM_ID = ? ";      
        MovieReserveVo vo = new MovieReserveVo(0, null, null, null);     
        try (   
            Connection connection = getConnection();   
            PreparedStatement pstmt = connection.prepareStatement(sql); 
        ){
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery(); 
            
            while(rs.next()){
                vo = new MovieReserveVo(rs.getInt(1),
                                                        rs.getString(2), 
                                                        rs.getString(3), 
                                                        rs.getDate(4));
            }
        } catch (SQLException e) {
            System.out.println("checkId 실행 예외 발생 : "+ e.getMessage());
        }
        return vo;
    }   
}
