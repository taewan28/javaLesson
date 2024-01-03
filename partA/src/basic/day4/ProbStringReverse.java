package basic.day4;

public class ProbStringReverse {

    public static void main(String[] args) {
        String message = "Hello~ World~ 자바는 맛있다.";
        char[] messageArray = new char[message.length()];

		for(int i=message.length()-1;i>=0;i--){
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[message.length()-i-1] = temp;
		}
        System.out.println(messageArray);
    
    }
}
