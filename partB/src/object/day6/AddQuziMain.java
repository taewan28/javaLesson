package object.day6;

public class AddQuziMain {
    public static void main(String[] args) {
    
    
    
    
        int start=1; int end=45;
        for(int i=0; i<10;i++){
            int temp = (int)(Math.random()*(end-start+1))+start;
        System.out.println("1~45 범위의 난수 : " + temp);
        }
    }
}