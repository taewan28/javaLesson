package basic.day4;

public class A23GuguDan {
    
    /*
     * 구구단은 반복의 반복입니다.
     * 2의 곱하기를 1부터 9까지 합니다. (1부터 9까지 반복)
     * 3에 곱하기를 1부터 9까지 합니다.
     * 4에 곱하기를 1부터 9까지 합니다.
     *          :
     * 9에 곱하기를 1부터 9까지 합니다.
     */
    
    public static void main(String[] args) {

        for(int i=2;i<9;i++)
        {
            System.out.println("지금..." + i +"단을 출력합니다.");
        for(int j=1;j<=9;j++){
            System.out.println(String.format("%3d x %3d = %3d",i,j,i*j));
        }
        
        }
    }   
}