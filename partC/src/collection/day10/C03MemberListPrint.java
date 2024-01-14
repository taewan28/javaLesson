package collection.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class C03MemberListPrint {

    public static void main(String[] args) {
        
         List<Member> list = new ArrayList<>();


        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));

        //toString 재정의된 출력이 아닌 직접 이름, 나이를 모두 출력
        System.out.println(String.format("%15s\t %15s", "NAME", "AGE"));

        for(int i=0; i<list.size(); i++){
            Member temp = list.get(i);
            System.out.println(String.format("%15s\t %15d", temp.getName(),temp.getAge()));
            System.out.println(String.format("%15s\t %15d", list.get(i).getName(),list.get(i).getAge()));

        }

        //컬렉션에선 반복자(Iterator)로 데이터에 접근한다.
        //반복자를 이용한 출력
        System.out.println(":::::반복자를 이용한 출력:::::");
        Iterator<Member> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Member temp = iterator.next();
            System.out.println("\t count = "+count++ +", 요소 = "+temp);
            
        }

        //iterator로 동작하는 for
        System.out.println(":::::iterator로 동작하는 for를 이용한 출력:::::");
        count=0;
        for (Member temp : list) {
            System.out.println("\t count = "+count++ +", 요소 = "+temp);
        }



    }
    
}
