package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        int A = 20;
        int B = 30;
        int C = 40;
        int max;
        System.out.println("누가 더 높냐?");
        //1)조건식이 참/거짓 각각 실행명령어가 다릅니다.
        if (A>B) {
            System.out.println("max(임시) = A");
            max = A;
        }else{
            System.out.println("max(임시) = B");
            max = B;
        }
        //2)조건식이 참일 때만 실행하는 명령어가 있습니다.
        if (max<C) {
            System.out.println("max(최종) = C ");
            max = C;
        }    
        System.out.println("A="+A +",B=" +B + ",C=" +C);
        System.out.println("최대값 max=" +max);
        
        A=99;
        B=88;
        C=77;
    System.out.println("::조건 삼항연산으로 다시 구현해보기::");
    //조건 삼항연산을 대입문에 활용해 봅시다.
    max=0;
    max = (A>B? A:B);
    max = (max<B? C:max);
    System.out.println("A="+A +",B=" + B + ",C=" +C);
    System.out.println("최대값 max="+max);
    }
}
