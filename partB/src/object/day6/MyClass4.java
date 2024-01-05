package object.day6;

public class MyClass4 {

    private String field1;
    private int field2;
    private double[] field3;

    //생성자 : 객체가 만들어지면서(메모리에 할당) 실행되는 메소드
    //메소드 인자가 없으면 기본 생성자
    public MyClass4 () {
        this.field2 = 5;
    }

    //메소드 인자가 있는 생성자 : 커스텀 생성자
    public MyClass4(String field1) {
        this.field1=field1;
    }

    public MyClass4(int field2) {
        this.field2 = field2;
    }
    
    public MyClass4(String field1,int field2) {
        this.field1=field1;
        this.field2=field2;
    }

    public MyClass4(String field1,int field2, double[] field3) {
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
    }

    //getter
    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public double[] getField3() {
        return field3;
    }

    //setter
    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public void setField3(double[] field3) {
        this.field3 = field3;
    }
    
}
