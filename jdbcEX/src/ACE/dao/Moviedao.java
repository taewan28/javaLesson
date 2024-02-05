package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ACE.vo.MovieVo;
import jdbc.day1.OracleConnectionUtil;

public class Moviedao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<MovieVo> selectByGenre(String category){
        List<MovieVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_movie where category = ? order by title";

        try (
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ){
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MovieVo(rs.getString(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("allCustomers 예외 발생 : "+e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public List<MovieVo> selectByTitle(String title){
        List<MovieVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * FROM TBL_movie WHERE title LIKE '%'||?||'%' order by category";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MovieVo(rs.getString(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("allCustomers 예외 발생 : "+e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
}
