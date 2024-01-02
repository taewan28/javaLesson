package basic.day3;

public class A15MinValue {          //가장 작은 값 찾기
    public static void main(String[] args) {
        int A = 20;
        int B = 30;
        int C = 40;
        int min;
        System.out.println("누가 더 높냐?");
        //1)조건식이 참/거짓 각각 실행명령어가 다릅니다.
        if (A<B) {
            System.out.println("min(임시) = A");
            min = A;
        }else{
            System.out.println("min(임시) = B");
            min = B;
        }
        //2)조건식이 참일 때만 실행하는 명령어가 있습니다.
        if (min>C) {
            System.out.println("min(최종) = C ");
            min = C;
        }    
        System.out.println("A="+A +",B=" +B + ",C=" +C);
        System.out.println("최소값 min=" +min);
        
        A=99;
        B=88;
        C=77;
    System.out.println("::조건 삼항연산으로 다시 구현해보기::");
    //조건 삼항연산을 대입문에 활용해 봅시다.
    min=0;
    min = (A>B? A:B);
    min = (min>B? C:min);
    System.out.println("A="+A +",B=" + B + ",C=" +C);
    System.out.println("최소값 min="+min);
    }
}
