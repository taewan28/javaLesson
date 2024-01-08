package object.test;

import object.day7.Shape;

public class Square extends Shape{


    //etc setter
    public void setEtc(String etc) {  
        this.etc=etc;       //Shape 의 상속클래스는 etc 필드 직접 사용
    }
    //round setter
    public void setRound(int round){
      //  this.round = round;
      // 오류 : Shape 과 가틍ㄴ 패키지 아니므로 직접 사용 못함.
    }
    
    @Override
    public void draw() {
        System.out.println("정삼각형" + this.getShapeName() + "를 그립니다.");
    }

}
    

