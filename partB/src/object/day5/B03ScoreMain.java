package object.day5;

public class B03ScoreMain {

    public static void main(String[] args) {
    
        Score momo = new Score();
        Score dahy = new Score();
        Score nayn = new Score();
        Score zzwi = new Score();

        momo.setname("모모");
        momo.setgrade(1);
        int[] m = {10, 20, 30};
        momo.setjumsues(m);
        System.out.println("모모의 점수 총합:"+ momo.sum(m));
        System.out.println("모모의 점수 평균:"+ momo.average(m));
        momo.printData();

        dahy.setname("다연");
        dahy.setgrade(1);
        int[] d = {40, 50, 60};
        dahy.setjumsues(d);
        System.out.println("다연의 점수 총합:"+ dahy.sum(d));
        System.out.println("다연의 점수 평균:"+ dahy.average(d));
        dahy.printData();
        
        nayn.setname("나연");
        nayn.setgrade(2);
        int[] n = {20, 30, 40, 50};
        nayn.setjumsues(n);
        System.out.println("나연의 점수 총합:"+ nayn.sum(n));
        System.out.println("나연의 점수 평균:"+ nayn.average(n));
        nayn.printData();
        
        zzwi.setname("쯔위");
        zzwi.setgrade(2);
        int[] z = {60, 70, 90, 100};
        zzwi.setjumsues(z);
        System.out.println("쯔위의 점수 총합:"+ zzwi.sum(z));
        System.out.println("쯔위의 점수 평균:"+ zzwi.average(z));
        zzwi.printData();
       


    //학생 4명의 성적을 저장해보세요.
    //1학년 2명(모모,다현) 3과목  2학년 2명(나연,쯔위) 4과목
    // 점수는 임의로 선정  
    
        

    
    } 
}
