package object.day9;

public class MemberCompareTest {
    
    //Member 객체를 비교하고 Member 배열 정렬도 할 수 있습니다.
    public static void main(String[] args) {
        Member momo = new Member("momo", 23);
        Member nana = new Member("nana", 20);

        System.out.println("모모의 나나를 비교(나이 기준)");
        System.out.println("\t" + momo.compareTo(nana));

    }
}
