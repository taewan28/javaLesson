package object.day6;

import java.util.Scanner;


public class AddQuziMain {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        AddQuiz [] my = new AddQuiz[5];


        System.out.println("\n덧셈 문제를 시작합니다.");
        int start = 11;
        int end  = 99;

        for(int i=0; i<my.length;i++){
            int temp1 = (int)(Math.random()*(end-start+1))+start;
            int temp2 = (int)(Math.random()*(end-start+1))+start;
            my[i] = new AddQuiz();
            my[i].setdata1(temp1);
            my[i].setdata2(temp2);
            my[i].isRight();
            System.out.println(String.format("%d번.\t %d + %d",i+1,my[i].getdata1(),my[i].getdata2()));
            System.out.print("답을 입력해 주세요 > ");
            my[i].setUserAnswer(sc.nextInt());
        }

        System.out.println("ㅡㅡㅡㅡㅡ채점 중입니다.ㅡㅡㅡㅡㅡㅡㅡ");

        System.out.println("\t 문제\t제출한 답\t정답\t채점");
      
        int count = 0;
        for(int i=0; i<my.length; i++){
            System.out.print(String.format("%d번.\t%d+%d\t%d\t\t%d", i+1, my[i].getdata1(),my[i].getdata2(),my[i].getUserAnswer(),(my[i].getdata1()+my[i].getdata2())));
            if (my[i].isRight()==true){System.out.println("\tO");
            count++;
            }else System.out.println("\tX");
            
        }
        System.out.println("\n::::: 맞은 개수는 " + count + "개 입니다.:::::"); 
    }
}

