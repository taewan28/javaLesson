package koreait2;

public class Drink extends Product {

    private boolean isAlcoholic;

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }
    
    public Drink(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }

    public boolean buy(){
        return isAlcoholic;
    }

    @Override
    public String produce(Object object) {
        return String.format("음료종류[%s] 1set - %d개",this.prdName,object);
    }

    @Override
    public String toString() {
        return String.format("Drink [prdName= %s price= %d  isAlcoholic= %b ]", this.prdName, this.price, this.isAlcoholic);
    }
}