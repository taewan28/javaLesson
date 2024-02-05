package koreait2;

public class Food extends Product{
    private int kcal;

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }


    public Food(int price, String prdName, int kcal) {
        this.prdName = prdName;
        this.price = price;
        this.kcal = kcal;
    }

    public double intake(int weight){
        double C = (double) kcal / weight * 30 * 100; 
        return C;
    }
    


    public String produce(Object object) {
        return String.format("[%s]생산지 - %s",this.prdName,object);
    }

    @Override
    public String toString() {
        return String.format("Food [prdName= %s price= %d  kcal= %d ]", this.prdName, this.price, this.kcal);
    }
    
}