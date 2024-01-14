package object.day9;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    

    @Override
    public String toString() {
        return String.format("Student [name = %s, age =%d]\n",this.name,this.age);
    }

}

/*
 * Member 클래스 compareTo 의 문제점. 비교 기준 또는 정렬방법(오름,내림)을 변경하려면 클래스 내부의
 *              compareTo 메소드 구현의 return 을 변경해야 합니다. Member 를 사용한 기존의 다른 프로그램에 영향.
 */