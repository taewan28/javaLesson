package object.day6;

public class B06ProductMain {

    //Product 객체를 4개 만들어보겠습니다.
    public static void main(String[] args) {
        Product snack = new Product("새우깡", 1200, "농심", new String[3]);
        Product drink = new Product("사이다", 1200, "롯데", new String[3]);
        Product fruit = new Product("사과",1200, "농원", new String[3]);
        Product icecream = new Product("투게더", 1200, "빙그레", new String[3]);

        //출력
        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);
        /*  object.day6.Product@2f92e0f4        -2f92e0f4은 객체 참조값(식별값) -> 주소라고 부릅시다.
            object.day6.Product@28a418fc        -object.day6.Product 는 패키지이름, 클래스이름.
            object.day6.Product@5305068a
            object.day6.Product@1f32e575 
         */
        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());

        //퀴즈 snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장
        String[] temp = snack.getEtc();         //가져온값 어떻게 저장?
        temp[0] = "10개 묶음";
        System.out.println(snack.getData());
        //snack.setPrice(1000);                //set 메소드 없음. ->오류
        //snack.price = 1000;                  //private - 오류

        String [] tep = drink.getEtc();
        tep[0] = "게임";
        System.out.println(drink.getData());


        Product[] mycarts = new Product[5];    //product 객체 배열 - Product 객체의 참조값 저장 배역
        mycarts[0]=drink;
        mycarts[1]=icecream;
        //mycarts[2]=drink;
        mycarts[3]=fruit;
        mycarts[4]=snack;
        System.out.println("~~~~~ mycarts ~~~~~");
        
        //배열이므로 반복문으로 출력할 수 있습니다. - gatData()메소드 사용
        for(int i=0;i<mycarts.length;i++){
            if(mycarts[i] !=null)
            System.out.println(mycarts[i].getData());   
            //mycarts[i] 가 null 일 때에는 메모리 할당이 안된상태.메소드 사용못합니다.
        }
    }
}
