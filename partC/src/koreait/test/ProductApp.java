package koreait.test;

import koreait.test.Bike.Electronics;

public class ProductApp {

    public static void main(String[] args) {
        Product[] cart = new Product[20];
            cart[0] = new Bike(123000, "MTB", 25);
            cart[1] = new Electronics(35000,"USB");
            cart[3] = new Bike(99000, "삼천리", 15);
            cart[0] = new Bike(123000, "MTB", 25);
        
    }
    
}
