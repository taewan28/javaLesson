package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {

    public static void main(String[] args) {
        
        List<String> strlist = new ArrayList<>();
        //List 인터페이스를 구현한 클래스가 ArrayList 이다

        strlist.add("트와이스");
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");

        System.out.println("문자열 LIST strlist size : "+strlist.size()); //? 답: 6
        System.out.println("\n  데이터 추가");
        strlist.add("르세라핌");
        System.out.println("항목 추가 후 리스트 : "+strlist);       //ArrayList클래스의 toString 재정의 메소드 실행

        System.out.println("\n  데이터 삭제");
        strlist.remove("원더걸스");
        System.out.println("항목 삭제 후 리스트 : "+strlist);
        strlist.remove(1);
        System.out.println("항목 삭제 후 리스트 : "+strlist);       //ArrayList클래스의 toString메소드 실행

        //아래 2개 메소드 비교
        strlist.add(2,"?????");     // 중간 삽입
        System.out.println("항목 변경 후 리스트 : "+strlist);       //ArrayList클래스의 toString메소드 실행
        strlist.set(2,"!!!!!!");    // 수정**
        System.out.println("항목 변경 후 리스트 : "+strlist);       //ArrayList클래스의 toString메소드 실행

        System.out.println("\n 특정 인덱스 위치의 요소값 가져오기");
        System.out.println("strlist.get(0) = " + strlist.get(0));
        System.out.println("strlist.get(3) = " + strlist.get(3));
        //System.out.println("strlist.get(9) = " + strlist.get(9));  //오류.요소없음.


        //addAll
        List<String> subList = new ArrayList<>();
        subList.add("투바투");
        subList.add("세븐틴");
        strlist.addAll(0, strlist);
        System.out.println("\n addAll sublist 실행 후 = " + strlist);
        strlist.add("아이브");
        System.out.println("\n 이미 저장되어 있는 값도 추가됩니까? " + strlist);            //중복값 허용
        
        //contains          indexof             lastUndexOf
        System.out.println("\n\n리스트에서 항목 찾기");
        System.out.println("\t 리스트에 처음 `아이브` 어디 있음? " + strlist.indexOf("아이브"));
        System.out.println("\t 리스트에 마지막 `아이브` 어디 있음? " + strlist.lastIndexOf("아이브"));
        System.out.println("\t 리스트에 `뉴진스` 있음? " + strlist.contains("뉴진스"));         //true , false 리턴
        System.out.println("\t 리스트에 `뉴진스` 어디 있음? " + strlist.indexOf("뉴진스"));
        
    }
    
}
/*
 * List 구현 클래스 특징 : 배열처럼 인덱스를 갖습니다. 인덱스가 있다는 것은 데이터의 순서가 있다는 의미 
 *                        배열에 없는 '삭제' 기능이 있습니다
 *                        그 외에도 조회와 관련 기능 등 조작과 조회를 다양하게 할 수 있습니다. 
 */