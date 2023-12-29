package basic.day2;

public class HomeStringFormat {
    public static void main(String[] args) {
        int hoge = 1;
    String str = String.format("변수hoge의 내용은%d이다.", hoge);
        System.out.println(str);
    }
}