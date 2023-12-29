package basic.day2;

public class A09HangilCharTest {
    
    public static void main(String[] args) {
        /*
         * 문자 '나'부터 '냿'까지 while문으로 출력해보세요. -> 변수 char start='나';
         *                      모두 몇개의 문자가 있는지 갯수 구하기. int codeNa, codeNet ;
         */
        char start='나';
        char end = '냿';
        int codeNa= start;      //'나'의 코드값
        int codeNet= end;  //'냿';             //'냿'의 코드값

        {
        while (start<= end){
          System.out.print(start++);
        }
        //** 이 시점에서의 start는?
        System.out.println("\nstart=????" + start);
        //2)
        System.out.println("\n start ~ end 까지 문자의 개수= " + (codeNet-codeNa+1));
        }         
    }
}