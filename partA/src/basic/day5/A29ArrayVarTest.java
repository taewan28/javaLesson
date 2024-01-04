package basic.day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A29ArrayVarTest {

    //데이터의 참조값과 관련된 테스트
    public static void main(String[] args) {
        //iArray, dArray, cArray 는 모든 배열의 참조값을 저장하는 변수입니다.
        int[] iArray = {1, 2, 3, 4, 5};
        double[] dArray = new double[5];
        char[] cArray = new char[5];
        cArray[0] = 'j';
        cArray[1] = 'a';
        cArray[2] = 'v';
        cArray[3] = 'a';
        cArray[4] = '!';
        //cArray[4] = '';  //''안에 비어있으면 오류. 반드시 1글자 필요.

        //iArray, dArray, cArray 배열 이름으로 출력하면 배열과 관련된 정보를 표시
        //                       그 정보에 참조값이 포함됩니다.
        System.out.print("1.   ");
        System.out.println(iArray);
        System.out.print("2.   ");
        System.out.println(dArray);
        System.out.print("3.   ");
        System.out.println(cArray);
        //System.out.println("1."+iArray+", 2."+dArray+", 3."+cArray);


        int[] temp;
        temp = iArray;      //iArray의 주소(참조값)를 temp변수에 저장
        System.out.print("4.   ");
        System.out.println(temp);

        System.out.print("\n5.참조값을 전달받은 temp 배열 확인");
        temp[3]=999;
        System.out.println("temp[3] = " + temp[3]);
        System.out.println("temp 배열의 값 : " + Arrays.toString(temp));
        System.out.println("\n6. 어라?? iArray 도 똑같네~~ !!!");
        System.out.println("iArray[3] =" + iArray[3]);
        System.out.println("iArray 배열의 값 : " + Arrays.toString(iArray));

        //다른 인덱스의 값도 바꿔보세요.
        System.out.println("다른 인덱스값 바꾸어 보기");
        iArray[1]=1234;
        System.out.println("\n7. temp와 iArray는 하나의 배열을 가리킵니다.!!!");
        System.out.println("temp 배열의 값 :" + Arrays.toString(temp));
        
        // 기본형과 참조형 비교.
        int age =23;
        int itemp;
        itemp = age;
        age =100;  //age만 변경

    }
    
}
