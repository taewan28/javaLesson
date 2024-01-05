package object.day6;

public class TestMain {

    public static void main(String[] args) {
        
        Test1 kim = new Test1("인간",1,new String[1]);
        Test1 tae = new Test1("오크",2,new String[2]);
        Test1 wan = new Test1("엘프",3,new String[3]);

        System.out.println(String.format("%s\t %s\t %s","종족","스킬수","스킬명"));
/*         System.out.println(kim.getgame());
        System.out.println(tae.getgame());
        System.out.println(wan.getgame()); */

        String[] temp = kim.getskillName();
        temp[0] = "하기싫어";
        System.out.println(kim.getgame());

        String[] tep = tae.getskillName();
        tep[0] = "하기";
        tep[1] = "싫어";
        System.out.println(tae.getgame());

        String[] tem = wan.getskillName();
        tem[0] = "하기";
        tem[1] = "싫어";
        tem[2] = "정말";
        System.out.println(wan.getgame());
        
    }
}
