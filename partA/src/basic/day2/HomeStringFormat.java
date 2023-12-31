package basic.day2;

public class HomeStringFormat {
    public static void main(String[] args) {
        int kim = 10;
        double wer = 6.156;
            String str = String.format("변수kim의 내용은 %d이다.", kim);
            String tae = String.format("변수wer의 내용은 %f이다", wer);
            String wan = String.format("TRUE%b, FALSE는 %b이다.", true, false);
            System.out.println(str);
            System.out.println(tae);
            System.out.println(wan);
    }
}