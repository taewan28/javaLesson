package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {

    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        //본래의 set은 순서가 없으므로 무작위 접근
        //Linked는 
        set.add("트와이스");
        set.add("아이브");
        set.add("잇지");
        set.add("뉴진스");
        set.add("트와이스");
        set.add("소녀시대");
        System.out.println(":::::HashSet:::::");
        System.out.println("set : "+set);
        System.out.println("set.size : "+set.size());


        Set<String> set2 = new LinkedHashSet();
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스");
        set2.add("소녀시대");
        System.out.println(":::::LinkedHashSet:::::");
        System.out.println("set2 : "+set2);
        System.out.println("set2.size : "+set2.size());

        System.out.println("\t set 데이터 요소 한개씩 접근하기");
        for(String temp : set){
            System.out.println("\t set 요소"+temp);
        }

        //set 인덱스 없습니다.
        //                      for(int i=0;i<set.size();i++) 와 같은 방식은 불가

        Set<String> set3 = new TreeSet<>();
        //본래의 set은 순서가 없으므로 무작위 접근
        //이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근합니다.
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스");
        set3.add("소녀시대");
        System.out.println(":::::TreeSet:::::");
        System.out.println("set : "+set3);
        System.out.println("set.size : "+set3.size());
    }
    
}

/*
 * Set : 수학의 집합과 같은것
 * 순서가(인덱스) 없음
 * 중복값이 없음
 * Map의 구성요소 : Key, Value 중에서 Key는 Set의 특성을 가진다.
 */