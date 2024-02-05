package koreait.solution;

// 0) 객체의 구성 요소 : 인스턴스 필드와 인스턴스 메소드
//    클래스 구성 요소 : 객체의 구성 요소 + static 메소드와 필드
//    클래스는 객체가 만들어지는 인스턴스 요소를 정의하는 상위 개념
public class Bike extends Product {         //상속
    //4) 필드
    private int speed;
    
    public Bike(int price, String prdName, int speed) {                //ctor
        //super();                                          
        //자식클래스는 부모 생성자 반드시 호출한다. -super()는 생략 가능합니다.
        this.price = price;
        this.prdName = prdName;
        //price 와 prdName 은 protected 필드이므로 자식은 직접 접근 가능합니다.
        this.speed = speed;
    }

    //8) 추상클래스 상속 받았으므로 반드시 추상메소드 구현(재정의)
    @Override
    public String sell(Object object) {
        return String.format("[%s] 행사 - %d %%인하", this.prdName,object);
        
    }

    //4)
    public int getSpeed() {
        return speed;
    }

    //4)
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //5) getter,setter,ride 메소드 : 인스턴스 필드를 대상으로 처리 기능을 갖습니다. 인스턴스 메소드
    //                               객체= 인스턴스                                    

    public String ride() {
        //this 생략 가능하나 speed 가 객체의 필드 변수라는 것을 가독성 있게 해줍니다.
        return "당신은 이것을 시속"+this.speed+"km로 탈수 있습니다.";
    }

    @Override
    public String toString() {
        return "Bike ["+super.toString()+"speed=" + speed + "]";
    }

}

class Eletronics extends Product{
    private double kwh;             //필드 : 클래스 소속된 변수. 클래스 전역 변수

    //3) price,prdName 필드값만 초기화 - 생성자
    public Eletronics(int price, String prdname) {
        //super();
        this.price=price;
        this.prdName=prdName;

    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double getKwh() {
        return kwh;
    }

    //9) 추상클래스 상속 받았으므로 반드시 추상메소드 구현(재정의)
    @Override
    public String sell(Object object) {
        return String.format("[%s]증정-%s", this.prdName,object);
        
    }

    //7)
    public double power() {
        return this.kwh*24;    
    }

    @Override
    public String toString() {
        return "Eletronics ["+ super.toString( ) +", kwh=" + kwh + "]";
    }

}
