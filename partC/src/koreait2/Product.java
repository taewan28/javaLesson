package koreait2;

public abstract class Product {
    protected int price;

    protected String prdName;

    public int getPrice() {
        return price;
    }

    public abstract String produce(Object object);

    
}
