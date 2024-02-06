package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ACE.vo.MovieReserveVo;

public class Reservedao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int reserve(MovieReserveVo vo){
        String sql = "insert into tbl_reserve(res_idx , custom_id, title,res_date)\n" +
                    "values (res_pk_seq.nextval,?,?,sysdate)";
        int result=0;
        try (   
            Connection connection = getConnection();   
            PreparedStatement pstmt = connection.prepareStatement(sql); 
        ){
            
            pstmt.setString(1, vo.getCustom_id());
            pstmt.setString(2, vo.getTitle());

            result=pstmt.executeUpdate();                                  
        } catch (SQLException e) {
            System.out.println("reserve 실행 예외 발생 : "+ e.getMessage());
        }
        return result;
    }

    public int delete(int res_idx){
        String sql = "DELETE FROM tbl_reserve WHERE res_idx = ?";
        int result=0;
        try ( 
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setInt(1, res_idx);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : "+ e.getMessage());
        }
        return result;
    }

    public int update(MovieReserveVo vo){
        String sql = "UPDATE tbl_reserve SET title = ? WHERE res_idx = ?";
        int result=0;
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setString(1, vo.getTitle());
            pstmt.setInt(2, vo.getRes_idx());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : "+ e.getMessage());
        }
        return result;
    }

    public List<MovieReserveVo> selectViewerReserveList(String viewerid){
        List<MovieReserveVo> list = new ArrayList<>();

        String sql = "SELECT res_idx , tr.title, price,  res_date "+
                    "FROM TBL_MOVIE tm , TBL_RESERVE tr "+
                    "WHERE tm.TITLE = tr.TITLE "+
                    "AND tr.CUSTOM_ID = ?"+
                    "ORDER BY RES_DATE DESC ";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setString(1, viewerid);
            ResultSet ps = pstmt.executeQuery();
            
            
            while (ps.next()) {
                list.add(new MovieReserveVo(ps.getInt(1),
                                            ps.getString(2),
                                            ps.getString(3),
                                            ps.getDate(4)
                                            ));
            }
            
        } catch (SQLException e) {
            System.out.println("selectCustomerBuyList 예외 발생 : "+e.getMessage());
            e.printStackTrace();
        }

        return list;
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
    
    public int getUserAge(String custom_id){
        int userAge = 0;
        String sql = "SELECT AGE FROM TBL_VIEWER WHERE CUSTOM_ID = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, custom_id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    userAge = rs.getInt("AGE");
                }
            }
        } catch (SQLException e) {
            System.out.println("getUserAge ERROR : " + e.getMessage());
        }
        return userAge;
    }

    public int getAgeLimit(String movietitle){
        int ageLimit = 0;
        String sql = "SELECT VIEW_AGE FROM TBL_MOVIE WHERE TITLE = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, movietitle);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    ageLimit = rs.getInt("VIEW_AGE");
                }
            }
        } catch (SQLException e) {
            System.out.println("getAgeLimit ERROR : " + e.getMessage());
        }

        return ageLimit;
    }

    public boolean checkAgeLimit(String custom_id, String movietitle){
        int Limit = 19;

        int userAge = getUserAge(custom_id);
        int movieAge = getAgeLimit(movietitle);

        return userAge < Limit && userAge < movieAge;
        
    }
    
}

  