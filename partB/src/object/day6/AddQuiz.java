package object.day6;

import java.util.Arrays;

public class AddQuiz {

    private int data1;
    private int data2;
    private int userAnswer;
    
    public int getdata1() {
        return this.data1;
    }

    public int getdata2() {
        return this.data2;
    }

    public int getUserAnswer() {
        return this.userAnswer;
    }

    public int getisRught() {
        return this.userAnswer;
    }
    
    
    public void setdata1(int data1) {
        this.data1 = data1;
    }

    public void setdata2(int data2) {
        this.data2 = data2;
        }

    
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    boolean

    public String getData(){
        return String.format("%15s\t %10d\t %-10s\t %-20s", data1, data2, userAnswer);

}

}
