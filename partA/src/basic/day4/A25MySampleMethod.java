package basic.day4;

public class A25MySampleMethod {
    
        //A22번 1)~5)을 각각 메소드로 정의해 보기 - 메소드안에서 출력문 만들지 않습니다.
        //1) sumToN  2)multiply1ToN  3)sumMTon  4)multtplyMToN 5)multiplyNof2    
        //6) 구구단 '출력'하는 메소드. 리턴은 void. printGuguDan


    public static void main(String[] args) {
        int n;
        int m;
        
        n =5;
        System.out.println(String.format("1부터 %d까지의 합계: %d",n,sumToN(n)));
        n = 10;
        System.out.println(String.format("1부터 %,d까지의 곱셈: %,d",n,multiply1ToN(n)));
        n =5; m =8;
        System.out.println(String.format("%,d부터 %,d까지의 합계: %,d",n,m,sumMTon(n,m)));
        n =5; m =8;
        System.out.println(String.format("%,d부터 %,d까지의 곱셈: %,d",n,m,multtplyMToN(n,m)));
        n =5;
        System.out.println(String.format("2의 %,d번 곱셈: %,d",n,multiplyNof2(n)));
        printGuguDan();


        int result = addMToN(2,5);
        boolean isOk = checkJumsu(67);
    }
    private static boolean checkJumsu(int i) {
        return i>=0 && i<=100;
    }

    
    
    
    private static int addMToN(int i, int j) {
        int sum =0;
        for(int k=i;k<=j;k++){
            sum+=k;
        }
        return sum;
    }



    //1) sumToN
    public static int sumToN(int a) {
        int sum =0;
        for(int i=1;i<=a;i++){
            sum +=i;
        }
        return sum;
    }
    
    //2)multiply1ToN
    public static int multiply1ToN(int a) {
        int longresult =1;
        for(int i=1;i<=a;i++){
            longresult *=i;
        }
        return longresult;
    }

    //3)sumMTon
    public static int sumMTon(int a,int b) {
    int sum = 0;
    for(int i=a;i<=b;i++){
        sum += i;
     }
     return sum;
    }

    //4)multtplyMToN
    public static int multtplyMToN(int a,int b) {
    int longresult = 1;
    for(int i=a;i<=b;i++){
        longresult *= i;
     }
     return longresult;
    }
    
    //5)multiplyNof2
    public static int multiplyNof2(int a) {
    int longresult = 1;
    for(int i=1;i<=a;i++){
        longresult *= 2;
     }
     return longresult;
    }
    
    //6)구구단
    public static void printGuguDan () {
        for(int i=2;i<9;i++)
        {
            System.out.println("지금..." + i +"단을 출력합니다.");
        for(int j=1;j<=9;j++){
            System.out.println(String.format("%3d x %3d = %3d",i,j,i*j));
        }
     }
    }
}