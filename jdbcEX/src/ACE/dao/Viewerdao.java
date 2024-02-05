package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
