package basic.day3;

//조건식을 사용하는 if문
public class A13ifElseTest {
    public static void main(String[] args) {
        int point = 69;      //처리사항 : 1)point 가 70 이상이면 vip, 70미만이면 일반회원으로 출력합니다.
                             //          2)vip 회원이면 이벤트 포인트 100 포인트 추가, 일반회원 50 포인트 추가
        System.out.println("이벤트 기간에 회원 포인트 추가 적립해 드립니다.!!!");
        if(point >=70) {
        System.out.println("Vip 회원이십니다.💕💕");
            //이모지 출력 : 윈도우 명령창 인코딩을 유니코드 UTF-8 로 변경해야 합니다. chcp 65001
            point += 100;
            }else {      //   point < 70 일때 실행
            System.out.println("일반 회원이십니다.🤞🤞");
                point +=50; 
            }
        System.out.println("고객님의 최종 포인트는 " + point + " 입니다.");
        
        //조건식? 참일때 실행명령 또는 값 : 거짓일때 실행명령 또는 값   =>연산부분이 3가지 즉 삼항연산이라고 합니다
        System.out.println("고객님의 최종 포인트는 " + (point>150? (point+=200):(point+=100)) + " 입니다.");
    }
}
