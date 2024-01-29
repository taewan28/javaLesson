package jdbc.day1;

public class CartApp {
    public static void main(String[] args) {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.println("아이디 입력 : ___");

        System.out.println("[1] 구매하기 [2] 구매 취소  [3] 구매 수량 변경");
        int select = Integer.parseInt(System.console().readLine());
        boolean run = true;

        while (run) {

            switch (select) {
                case 1: //[1] 구매하기 - buy 에 insert (1행)
                    
                    break;
                        // 구매 취서 - delete
                        // [3] 구매 수량 변경 - update
                default:
                    break;
            }
            
        }
    }
}   //tbl_buy 테이블을 대상을 insert, update, delete 할 수 있는 dao 클래스 만들기 TblBuyDao.java
    //      테이블 컬럼과 1:1 대응되는 BuyVo.java
    //      테이블 PK 컬럼은 buy_IDX - update,delete 의 조건 컬럼입니다.
