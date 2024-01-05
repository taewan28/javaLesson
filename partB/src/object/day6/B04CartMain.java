package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {

    public static void main(String[] args) {
        Cart momos_cart = new Cart();           //String, String[],int[] 필드는 null

        //모모의 장바구니- 상품이름, 가격
        String[] products ={"새우깡", "칠성사이다","빅토리아","제주감귤","나주배","삽립호빵","이클립스"};
        int[] prices = {3000,2500,9900,12000,9800,6000,1500};

        //장바구니 값을 저장합니다
        momos_cart.setUserid("momo");
        momos_cart.setProductNames(products);
        momos_cart.setPrices(prices);

        Scanner sc = new Scanner(System.in);

        System.out.println(momos_cart.getUserid() + "님의 장바구니 입니다.");
        System.out.println(String.format("%s\t %20s\t %s\n","번호","상품명","가격"));

        for(int i=0;i<momos_cart.getProductNames().length;i++){
            System.out.println(String.format("%s\t %20s\t %s\n", i,products[i],prices[i]));
        }

        System.out.println("구매할 상품 번호를 선택하세요. 선택 종료는 -1 입니다.");
        int sel =0;
        int[] select = new int[10];
        int k=0;
        while (sel!=-1 && k<select.length) {
            System.out.print("상품번호 입력 >>>");
            //sel의 선택범위는 produvtNames 범위값만
            sel = sc.nextInt();
            if(sel<-1 || sel > products.length-1){
                System.out.println("없는 상품입니다. 상품을 더 담아주세요~~");
                continue;       //아래 있는 명령어 실행하지 않고 다시 반복문 시작으로 돌아가기
            }
            select[k++]=sel;
            
        }
            System.out.println("장바구니 가득채우셨군요 ~^^ 땡큐 ~ ❤😍");

            System.out.println("선택하신상품은 "+ Arrays.toString(select));
            
            //momos_cart.setTotal_Money(200000);     //setter 메소드가 여기서는 필요없습니다
                                                 //total_Money 메소드가 대신 값을 계산해서 저장할 것입니다.

        momos_cart.total_Money(select);
        System.out.println(momos_cart.getUserid()+"님이 선택하신 상품 합계 : " + momos_cart.getTotal_Money());        
        //System.out.println("모모 님이 선택하신 상품 합계 : " + momos_cart.total_Money(select));
        
        //필요에 따라서는 기존의 setter 메소드는 사용하지 않고 추가적인 비지니스로직을 구현하는 메소드를 만듭니다.

    }
    
}
