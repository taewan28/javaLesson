package object.day6;

import java.util.Arrays;

public class Cart {

    private String userid;
    private String[] productNames;
    private int[] prices;
    private int total_Money;

    public String getUserid() {
        return this.userid;
    }
    
    public String[] getProductNames() {
    return this.productNames;
    }
    
    public int[] getPrices() {
        return this.prices;
    }

    public int getTotal_Money() {
        return this.total_Money;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public void total_Money(int[] select) {     //setter 역할
        int sum = 0;
        for(int i=0;i<select.length;i++){
            int temp = select[i];
            if(temp == -1) break;  //반복문 중지
            sum += prices[temp];
        }
        this.total_Money = sum;
    }



  /*   public int total_Money(int[] select) {
        int sum = 0;
        for(int i=0;i<select.length;i++){
            int temp = select[i];
            if(temp == -1) break;  //반복문 중지
            sum += prices[temp];
        }
        return sum;
    }  */
        

     public void printData(){
        System.out.println("사용자 = " + userid + ", 상품이름 = " + productNames +", 상품가격 = "+Arrays.toString(prices));
    }
}
