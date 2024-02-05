package koreait.test;

public class Bike extends Product{
    
    private int speed;
    
    public Bike(int price,String prdName, int speed) {
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public String ride(){
        return "당신은 이것을 시속"+ this.speed+"km로 탈수 있습니다.";
        
    }

    

    @Override
    public String sell(Object object) {
        return String.format("[%s] 행사 - %d%%인하",prdName,object);
    }

    @Override
    public String toString() {
        return "Bike [speed=" + speed + "]";
    }

    
}

class Eletronics extends Product{
    
    private double kwh;

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    } 

    public double power(){
        return this.kwh*24;
    }

    @Override
    public String toString() {
        return "Eletronics [kwh=" + kwh + "]";
    }

    @Override
    public String sell(Object object) {
        return String.format("[%s] 증정- %s",prdName,object);
    }
    
    

}