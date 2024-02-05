package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.ProductVo;

public class TblProductDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME = "C##idev";
    private static final String  PASSWORD= "1234";
    
      private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //카테고리로 검색하기
    public List<ProductVo> SELECTByCategory(String category){
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT *FROM TBL_PRODUCT \r\n" + 
                            "WHERE CATEGORY =? \r\n" +
                            "ORDER BY PNAME\r\n";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { //조회결과는 n행 가능성 예측
                list.add(new ProductVo(rs.getString(1),
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4))); 
                              }
        }
        catch(Exception e) {
            System.out.println("SELECTByCategory 예외 발생 : " + e.getMessage());
        }
        return list;
    }

    //3. 상품명으로 검색하기(유사검색 -> '검색어가 포함된 상품명'을 조회)
    public List<ProductVo> selectByPname(String Pname){
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT *FROM TBL_PRODUCT \r\n" + 
                            "WHERE PNAME LIKE '%' || ? || '%'\r\n" +
                            "ORDER BY CATEGORY\r\n";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sql))
        {
            pstmt.setString(1, Pname);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { //조회결과는 n행 가능성 예측
                list.add(new ProductVo(rs.getString(1),
                                        rs.getString(2), 
                                        rs.getString(3),
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