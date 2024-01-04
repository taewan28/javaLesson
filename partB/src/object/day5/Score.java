package object.day5;

import java.util.Arrays;

//학생들의 성적을 객체로 만들어 줄 클래스 입니다.
public class Score {

    private String name;        //학생 이름
    private int grade;          //학년
    private int[] jumsues;      //점수들이 저장될 배열
                                // 배열의 크기는 학년마다 다를 수 있음.

    //getter
    public String getname(){
        return name;
    }

    public int getgrade(){
        return grade;
    }

    public int[] getjumsues(){
        return jumsues;
    }


    //setter
    public void setname(String n){
        name = n;
    }
        public void setgrade(int g){
        grade = g;
    }
    public void setjumsues(int[] j){
        jumsues = j; 
        //jumsues = new int[j.length];
        //for(int i=0;i<j.length;i++)
          //  jumsues[i] = j[i];
    }

//점수의 합계를 리턴하는 sum() 메소드
    public int sum(int[] s) {
        int sum = 0;
        for(int i=0;i<s.length;i++){
        sum +=s[i];
        }
        return sum;
    }
    public int average(int[] s) {
        int average = 0;
        for(int i=0;i<s.length;i++){
        average +=s[i];
        }
        return average / s.length;
    }
    public void printData(){
        System.out.println("학생 이름 = " + name + ", 학년 = " + grade +", 점수 = "+Arrays.toString(jumsues));
        System.out.println();
    }
}

    //점수의 평균 double 리턴하는 average() 메소드


    //모든 인스턴스 필드값을 확인 출력하는 printSore() 메소드
    

