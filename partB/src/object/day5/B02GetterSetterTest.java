package object.day5;

import java.util.Arrays;

public class B02GetterSetterTest {
    public static void main(String[] args) {
        
        MyClass2 momo = new MyClass2();
        


        System.out.println("MyClass2 의 field1 값 (초기) :"+momo.getField1());
        momo.setField1("나는 모모!!");
        System.out.println("MyClass2 의 field1 값 (변경후) :"+momo.getField1());
        String message = "WELCOME";
        momo.setField1(message);
        System.out.println("MyClass2 의 field1 값 (변경후) :"+momo.getField1());



        System.out.println("\nMyClass2 의 field2 값 (초기) :"+momo.getField2());
        momo.setField2(888);
        System.out.println("MyClass2 의 field2 값 (변경후) :"+momo.getField2());
        System.out.println("지금까지의 momo 객체 값들은....");
        momo.printData();



        int test = 1212;
        momo.setField2(test);
        System.out.println("MyClass2 의 field2 값 (변경후) :"+momo.getField2());
        System.out.println("지금까지의 momo 객체 값들은....");
        momo.printData();



        System.out.println("\nMyClass2 의 field3 값 (초기) :"+momo.getField3());
        momo.setField3(new double[5]);
        System.out.println("MyClass2 의 field3 값 (변경후) :"+momo.getField3());
        double [] set = {12.3, 13.5,4.89};
        momo.setField3(set);
        System.out.println("MyClass2 의 field3 값 (변경후) :"+momo.getField3()+","+Arrays.toString(set));
        momo.printData();



        System.out.println("~~~~~field3은 double배열 타입입니다.~~~~~");
        double[] dArray = momo.getField3();
        System.out.println("field3 : " + dArray);



        double[] tempArray = {1.2,5.66,9.42};
        momo.setField3(tempArray);
        System.out.println("변경된 field3 확인합니다");
        momo.printData();
        momo.setField3(new double[5]);
        System.out.println("변경된 field3 확인합니다");
        momo.setField3(tempArray);
        momo.printData();
        


        //setField3을 변수로 전달했을 때
        tempArray[2]=3.1415;
        System.out.println("변경된 field3 확인합니다");
        momo.printData();
    


        System.out.println("\nMyClass2 의 field3 값 (초기) :"+momo.getField3());
        momo.setField3(new double[3]);
        System.out.println("MyClass2 의 field3 값 (변경후) :"+momo.getField3());
        momo.printData();
    
    }
}


/*
 * 오늘의 새로운 내용.
 * 1) 객체를 만들었다
 * 2) 객체는 인스턴스 필드와 인스턴스 메소드를 갖고 있으면 이것들은 객체가 주인되어 실행되어야 합니다.
 * 
 *    객체 변수가 momo 일때, momo.getfield1()에서 getfield1()는 인스턴스 메소드입니다.
 * 3) 객체의 인스턴스 필드는 private 으로 접근을 제한하는 것이 객체지향의 특징
 *                   ㄴ 값을 읽어오는 getXXX, 값을 저장하는 setXXX메소드 만들기
 * 4) 인스턴스 필드가 참조변수 일때에는 '주소'의 개념을 꼭 먼저 생각하기
 *                   ㄴ getter,seter 메소드의 인자와 리턴값이 주소입니다.
 */