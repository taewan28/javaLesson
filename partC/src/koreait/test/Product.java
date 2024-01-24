package koreait.test;

public class Product {

    protected int price;
    protected String prdName;
    protected int speed;

    public void prdName(int price, String prdName, int speed){
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;

    }

    public int getPrice() {
        return price;
    }

    public String getPrdName() {
        return prdName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

        @Override
    public String toString() {
        return String.format("["+prdName+"%s] 행사 - %ㅇ %%인하",this.price,this.prdName,this.speed);
    }
}