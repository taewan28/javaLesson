package basic.day3;

public class HomeCharType {
    public static void main(String[] args) {
        String message = "Hello* Java Hi* Linux~~~";
        
        System.out.println("문자열을 구성하는 문자 하나하나가  '대문자' '소문자' '숫자' '기호' 중 어떤 종류의 문자인지 검사");
        System.out.println("검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력.");
        System.out.println("문자열 :" + message);
        
        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        int symbolCount = 0;   

        for(int i=0; i<message.length(); i++) {   
            char tae = message.charAt(i);
            if (tae>64 && tae<91) upperCount++;
            else if (tae>96 && tae<123) lowerCount++;
            else if (tae>48 && tae<58) numberCount++;
            else if (tae>31 && tae<48) symbolCount++;
            else if (tae>57 && tae<64) symbolCount++;
            else if (tae>122 && tae<128) symbolCount++;
        }
        System.out.println("문자 종류 : 대문자 " +upperCount+"개, 소문자 " +lowerCount+"개, 숫자 "+numberCount+"개, 기호 "+symbolCount+"개");  
    }
}
/*
:::: [과제-2024/01/03 22시까지 제출] 문자열을 구성하는 문자의 종류 분석하기 ::::
1) 문자열을 임의로 저장합니다. 예시 : "Hello* Java Hi* Linux~~~" 

2) 1)번의 문자열을 구성하는 문자 하나하나가  '대문자' '소문자' '숫자' '기호' 중 어떤 종류의 문자인지 검사합니다.

3) 2)번의 검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력합니다.
변수명 :      대문자의 갯수 upperCount , 
             소문자의 갯수 lowerCount, 
             숫자의 갯수 numberCount, 
             기호의 갯수 symbolCount 

출력 예시 :  
------------------------------------------------------------
문자열 : Hello* Java Hi* Linux~~~
문자 종류 : 대문자 4개, 소문자 12개, 숫자 0개, 기호 8개  


 */