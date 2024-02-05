package koreait.test;

public abstract class Product {

    protected int price;

    protected String prdName;

    public abstract String sell(Object object);

    @Override
    public String toString() {
        return "Product [price=" + price + ", prdName=" + prdName + "]";
    }
}