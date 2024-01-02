package basic.day3;

public class HomeCharType {
    public static void main(String[] args) {
        String message = "Hello* java Hi* Linux~~~";
        
        System.out.println("\n2.문자열 길이 만큼 반복문 실행하면서 if 조건문으로 문자열 검사하기");
        System.out.println("\nt문자열에서 알파벳 o의 갯수 구해봅시다.");
        int count = 0;
            for(int i=0; i<message.length(); i++) {   
                char temp = message.charAt(i);
                System.out.println("i="+i +", 문자="+temp);
                if (temp=='o') count++;
            }
            System.out.println("문자열에서 알바벳 o의 갯수는 = "+ count);
    }
}
