package object.day6;

public class Myclass3 {
    //인스턴스 필드 : 클래스 내부에서 사용가능한 전역변수
    private String field1;
    private int field2;
    private double[] field3;

    public String getfile1(){
        return this.field1;
    }   //this는 현재 자신 객체를 나타내는 변수 : getter 에서는 생략하고 쓸수 있음

    public int getField2() {
        return this.field2;
    }
    
    public double[] getField3() {
        return this.field3;
    }
    
    public void setField1(String field1) { //인자로 쓰인 매개변수 : setField1 메소드의 지역변수
        this.field1 = field1;       //현재객체의 field1값에 인자 field1 대입하기
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public void setField3(double[] field3) {
        this.field3 = field3;
    }
}
