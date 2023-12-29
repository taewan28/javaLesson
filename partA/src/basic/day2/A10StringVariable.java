package basic.day2;

public class A10StringVariable {
    public static void main(String[] args) {
        //String 은 문자열 : 문자('')의 집합
        String message = "Hello~ 안녕!! 하이하이";
        
        System.out.println(message);
        System.out.println("메세지 '"+ message+"'의 길이 : " + message.length());

        message="Welcome~ java world!!!!";
        System.out.println("메세지'"+message+"'의 길이 : "+message.length());

        //String 으로 선언된 변수는 '객체'입니다.
        // 그래서 여러가지 메소드를 갖고 필요한 기능들을 제공해 줍니다.

        //char imo = '😊';  //char은 2바이트 이모지는 4바이트. 문자형으로 저장 안됨.
        String imo = "😂";  //이모지는 문자열로 저장해야 합니다. 이모티콘 단축키: 윈도우+세미클론
        System.out.println(imo);
        // 자바 String의 중요한 메소드 7가지씩 조사해서 테스트 해보기 - 

        //charAT() : 문자 추출
        String str = "자바 프로그래밍";
        System.out.println(str.charAt(0));
        
        //indexOf() : 문자열 찾기
        String rea = "hello world"; 
        System.out.println(rea.indexOf('e'));
        
        //replce() : 문자열 대치
        String oldStr = "자바 프로그래밍";
        System.out.println(oldStr);
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println(newStr);

        //substring() : 문자열 잘라내기
        String tae = "951128-13278945";
        String fristname = tae.substring(0, 6);
        System.out.println(fristname);
        String secondname = tae.substring(10);
        System.out.println(secondname);
    }
}
