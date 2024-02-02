package ACE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ACE.vo.MovieVo;
import project.vo.ProductVo;

public class MovieReportdao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME = "C##idev";
    private static final String  PASSWORD= "1234";
    
      private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public List<MovieVo> SELECTByCategory(String category){
        List<MovieVo> list = new ArrayList<>();
        String sql = "SELECT *FROM TBL_MOVIE \r\n" + 
                            "WHERE CATEGORY =? \r\n" +
                            "ORDER BY TITLE\r\n";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { //조회결과는 n행 가능성 예측
                list.add(new MovieVo(rs.getString(1),
                                        rs.getString(2), 
                                        rs.getInt(3),
                                        rs.getInt(4))); 
                              }
        }
        catch(Exception e) {
            System.out.println("SELECTByCategory 예외 발생 : " + e.getMessage());
        }
        return list;
    }

    public List<MovieVo> selectByPname(String title){
        List<MovieVo> list = new ArrayList<>();
        String sql = "SELECT *FROM TBL_MOVIE \r\n" + 
                            "WHERE TITLE LIKE '%' || ? || '%'\r\n" +
                            "ORDER BY CATEGORY\r\n";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { //조회결과는 n행 가능성 예측
                list.add(new MovieVo(rs.getString(1),
                                        rs.getString(2), 
                                        rs.getInt(3),
                                        rs.getInt(4))); 
                              }
        }
        catch(Exception e) {
            System.out.println("selectByPname 예외 발생 : " + e.getMessage());
        }
        return list;
    }

     public Map<String, Integer> getPriceTable(){
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,price from tbl_product";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { //조회결과는 n행 가능성 예측
                map.put(rs.getString(1),
                        rs.getInt(2)); 
                              }
        }
        catch(Exception e) {
            System.out.println("selectByPname 예외 발생 : " + e.getMessage());
        }
        return map;
    }
}
