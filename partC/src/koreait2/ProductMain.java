//김태완

package koreait2;

public class ProductMain {

    public static void main(String[] args) {
        
        //1.
        Product cart [] = new Product[10];

        cart[1] = new Food(5000,"까페라떼", 220);
        cart[3] = new Food(2400,"불닭볶음면",150);
        cart[4] = new Food(1200,"3분카레",260);
        
        cart[2] = new Drink(1200,"탄산수");
        cart[5] = new Drink(5500,"맥주");
        cart[7] = new Drink(3400,"코카콜라");

        //2
        if(cart[5] instanceof Drink){
            Drink beer = (Drink)cart[5];
            beer.setAlcoholic(true);
            System.out.println(beer.buy());
        }else{
            System.out.println("다운캐스팅 불가능");
        }

        //3
        for(Product p : cart){
            if(p != null && p.getPrice()<5000){
                System.out.println(p);
            }
        }

        //4
        for(Product p : cart){
            if (p !=null && p instanceof Food) {
                Food A = (Food) p;
                System.out.println(A.intake(60));
            }
        }

        System.out.println(cart[4].produce("청주 공장"));

        System.out.println(cart[5].produce(6));

    }   
}
