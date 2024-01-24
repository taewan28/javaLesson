package koreait.test;

public class Bike extends Product{

    public Bike(int price, String prdName, int speed) {
        
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;

    }
 
@Override
public String getPrdName() {

    return super.getPrdName();

}
@Override
public int getPrice() {

    return super.getPrice();

}

@Override
public int getSpeed() {

    return super.getSpeed();
 
}
    

class Electronics extends Product{

    public Electronics(int price, String prdName) {
        
        this.price = price;
        this.prdName = prdName;

    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getPrdName() {
        return super.getPrdName();
    }

  }
}