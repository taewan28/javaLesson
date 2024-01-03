package basic.day4;

// 문자열은 문자의 집합. 따라서 문자열 구성하는 문자 하나씩 가져와 배열에 저장해 봅니다.
public class A28CharArray {
    public static void main(String[] args) {
        String message = "Hello~ World~ 자바는 맛있다.";

        //문자열의 길이 만큼 배열의 크기를 정합니다.
        char[] messageArray = new char[message.length()];

        for(int i=0; i<message.length();i++){
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[i] = temp;
        }
        
        //char 배열의 특징. 배열이름으로 println 하면? 문자열처럼 출력됩니다. 
        System.out.println("~~~~~~~~~~메세지 원문 :");
        System.out.println((messageArray));

        //고대 암호: '모모'가 '나연'이 한테 비밀 메시지를 보냅니다.암호문을 만듭니다.
        //          두 사람이 알고 있는 비밀키 값 key=7 을 정했습니다. 암호문은??
        int key = 7;
        for(int i=0;i<message.length();i++) {
            messageArray[i]+=key;
        }
        System.out.println("\n~~~~~~~~~~~모모가 나연이한테 보낸 비밀 메시지 :");
        System.out.println(messageArray);


        System.out.println("\n나연이는 받은 메시지를 읽으려고 암호문을 풀었습니다.");
        
        for(int i=0;i<message.length();i++) {
            messageArray[i] -=key;
        }
        System.out.println("\n~~~~~~~~~~~해독문 :");
        System.out.println(messageArray);
    }
}



//오늘의 수업 내용(240103)

/*
 * 1)for문 완벽하게 사용하기. 특히 조건식
 * 2)사용자(개발자)가 정의하는 메소드 형식
 * 		-인자,리턴값
 * 		-인자는 형식 매개변수, 실매개변수로 구분해서 이해하기
 * 		-static 메소드는 main 에서 실행하기 위함
 * 3)배열
 * 		-for(또는 while) 반복문이 꼭 필요합니다.
 * 		-int 배열, char 배열
 * ==>1~3번까지 80프로 이상 이해하고 문제를 도전하세요.
 * 4)마지막 문제 : ProbStringReverse.java
 * 		:message 문자열이 "Hello World"일 때 문자열을 뒤집기
 */
