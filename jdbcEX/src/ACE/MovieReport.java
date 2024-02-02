package ACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ACE.vo.MovieVo;
import project.vo.ProductVo;


// CartApp_4 는 다른 클래스의 상위 클래스로 상속 관계를 만들 수 있다.
//              ㄴ 단,  main 메소드도 제거하고 
//                      인스턴스 메소드는 pivate 이외 다른  접근 한정자로 해야합니다.     
public class MovieReport {
    private MovieReportdao buyDao = new MovieReportdao();
    private MovieReportdao moviereportdao = new MovieReportdao();
    //private List<BuyVo> cart = new ArrayList<>();       //장바구니
    //private Map<String,Integer> priceMap = null;        // 물품 가격표 // 장바구니의 총 결제 금액 구할 때 사용


    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[C] 장르별 영화 조회      [P] 제목명 검색     [M]나의 구매내역   [T]\n" + //
                "");
        System.out.println("[B] 구매하기   [D] 구매 취소  [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(70));
    }


    private void showProductListByCategory() {
        System.out.println("카테고리 : A1-로맨스 A2-공포  B1-액션  B2-코미디 C1-기타");
        System.out.print("카테고리 입력__");
        String category = System.console().readLine();
        List<MovieVo> movieList = moviereportdao.SELECTByCategory(category);
        for(MovieVo vo : movieList)
        System.out.println(vo);
    }

    public void searchProductListByPname() {
        System.out.print("영화 정보 입력__");
        String title = System.console().readLine();
        System.out.println("  영화 제목       장르        관람가      가격" );
        List<MovieVo> movieList = moviereportdao.selectByPname(title);
            for(MovieVo vo : movieList)
                System.out.println(vo);
                
    }  

    
    public static void main(String[] args) {
        MovieReport app = new MovieReport();
        app.start();
    }
    
    public void start() {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(customerid + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select) {
                case "M","m":   // 나의 구매내역
                    //showMyPage(customerid);
                    break;
                case "C","c":
                    showProductListByCategory();
                    break;  
                case "P","p":
                    searchProductListByPname();    
                    break;
                case "A","a":
                    //addCartItem(customerid);
                    break;
                case "L","l":
                    //showCartList();
                    break;
                case "R","r":
                    //removeCartItem();
                    break;
                case "T","t":
                    
                    break;     
                case "Y","y":
                    //buyCartItems();
                    break;
                case "X","x":
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }






}   