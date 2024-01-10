package object.day9;

/*
 * 인터페이스 예시 - 비교 가능한 객체 만들기
 *                ㄴ 객체 비교 방법 1)Comparable 인터페이스 구현하도록 합니다.
 * Comparable<Member> 는 <> 에 타입을 표시합니다. 이런 방식을 제너릭 타입
 *                    제너릭 타입은 클래스 또는 인터페이스의 메소드에게 타입을 매개변수로 전달하기 우히나 방식.
 *                    이 떄 타입이 실행 시점에서 결정되기 때문입니다. 기본형은 Wrapper 클래스로 사용
 *                    Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달합니다.
 * Comparable : 비교할수 있는
 */
public class Member implements Comparable<Member> {
    private String id;
    private int age;

    public Member(String id, int age){
        this.id = id;
        this.age = age;
    }
    
    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Member [id=" + id + ", age=" + age + "]\n";
    }

    public int getAge() {
        return age;
    }

    //Comparable 인터페이스의 추상메소드 compareTo 를 구현합니다.
    @Override
    public int compareTo(Member o) { //메소드의 인자 탑입 Member 는 <> 제너릭 타입과 같게 만들어집니다.
            //현재 객체 this를 인자로 전달되는 Member 객체와 비교합니다.
            //비교 기준은 요구사항에 따라 개발자가 정합니다. 
            // 만약에 나이로 한다면
                 //return this.age - o.age;                 //나이 오름차순(기본)
                 //return o.age-this.age;                   //나이 내림차순
            //만약에 이름(id)으로 한다면
                    //return this.id.compareTo(o.id);       //이름 오름차순(기본)
                    return o.id.compareTo((this.id));       //이름 내림차순
    }
}
