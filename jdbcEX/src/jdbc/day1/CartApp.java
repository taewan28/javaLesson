package jdbc.day1;

import project.dao.TblBuyDao;
import project.dao.TblCustomerDao;
import project.vo.BuyVo;
import project.vo.CustomerVo;

public class CartApp {
    public static void main(String[] args) {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.println("아이디 입력 : ___");
        String customid = System.console().readLine();
        boolean run = true;

        while (run) {
            System.out.println("[1] 구매하기 [2] 구매 취소  [3] 구매 수량 변경 [4]구매 종료");
            int select = Integer.parseInt(System.console().readLine());
            TblBuyDao dao = new TblBuyDao();
            switch (select) {
                case 1: 
                    System.out.println(" 구매 물품을 구매하세요");
            
                    System.out.print(" 코드를 입력하세요. __ ");
                    String pcode = System.console().readLine();
            
                    System.out.print(" 수량을 입력하세요. __ ");
                    int quantity = Integer.parseInt(System.console().readLine());

                    BuyVo vo = new BuyVo(0, customid, pcode, quantity, null);
                    dao.insert(vo);
                    break;
                case 2:
                        System.out.println("우리 쇼핑몰 [구매 취소]- 합니다.");
                        System.out.print(" 인덱스 번호를 입력하세요. __ ");
                        int buy_IDX = Integer.parseInt(System.console().readLine());
                        dao.delete(buy_IDX);
                        break;
                case 3:
                        System.out.println("우리 쇼핑몰 [구매 수량 변경]- 합니다.");
                        System.out.print(" 인덱스 번호를 입력하세요. __ ");
                        buy_IDX = Integer.parseInt(System.console().readLine());

                        System.out.print(" 상품 코드를 입력하세요. __ ");
                        pcode = System.console().readLine();
                
                        System.out.print(" 수량를 입력하세요. __ ");
                        int Quantity = Integer.parseInt(System.console().readLine());
                        vo = new BuyVo(buy_IDX, customid, pcode, Quantity, null);
                        dao.update(vo);

                    break;   
                    
                default:
                     System.out.println("프로그램 종료.");
                    break;
            }
            
        }
    }
}   //tbl_buy 테이블을 대상을 insert, update, delete 할 수 있는 dao 클래스 만들기 TblBuyDao.java
    //      테이블 컬럼과 1:1 대응되는 BuyVo.java
    //      테이블 PK 컬럼은 buy_IDX - update,delete 의 조건 컬럼입니다.
