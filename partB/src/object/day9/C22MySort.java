package object.day9;

import java.util.Arrays;


public class C22MySort {
     public static void main(String[] args) {
        int[] numbers = {34,54,65,67,89};
        System.out.println("초기 numbers ="+ Arrays.toString(numbers));
            for(int i=0;i<numbers.length-1;i++){
                for(int j=i+1;j<numbers.length;j++){
                    //오름 차순은 number[i] 가 number[j] 값보다 작거나 같아야 합니다.
                    //비교 조건과 맞지 않으면 numbers[i] 와 numbers[j]를 교환하기
                    if (numbers[i]>numbers[j]) {
                        int tmep = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = tmep; 
                   }
                   System.out.println(String.format("중간 상태 : i=%d, j=%d : %s",i,j,Arrays.toString(numbers)));
                }
        }
        System.out.println("오름차순 정렬 후 numbers =" + Arrays.toString(numbers));

        System.out.println("\n내림차순 정렬 후 numbers =" + Arrays.toString(numbers));

                for(int i=0;i<numbers.length-1;i++){
                for(int j=i+1;j<numbers.length;j++){
                    //내림 차순은 number[i] 가 number[j] 값보다 크거나 같아야 합니다.
                    //비교 조건과 맞지 않으면 numbers[i] 와 numbers[j]를 교환하기
                    if (numbers[i]<numbers[j]) {
                        int tmep = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = tmep; 
                   }
                   System.out.println(String.format("중간 상태 : i=%d, j=%d : %s",i,j,Arrays.toString(numbers)));
                }
        }
    }
}
