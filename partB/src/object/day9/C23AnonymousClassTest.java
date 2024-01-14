package object.day9;

import object.day8_interface.beable.BeAble;
import object.day8_interface.beable.Cookable;


public class C23AnonymousClassTest {

    public static void main(String[] args) {
        

        Cookable aiCookable = new Cookable() {
            //추상메소드 정의(구현)

            @Override
            public String beAble() {
                return "cooking machine";
            }

            @Override
            public void cook(String material) {
                System.out.println("요리하는 기계입니다. " + material +" 레시피를 주세요");

            }
            
        };
        System.out.println(aiCookable.beAble());
        aiCookable.cook("생닭");

        //재정의 해야할 메소드가 1개 입니다. BeAble 인터페이스의 추상메소드가 1개 입니다.
        //      ㄴ 함수형 인터페이스: 익명 클래스를 '람다식'으로도 정의할 수 있습니다.
        BeAble beAble = new BeAble() {
            @Override
            public String beAble() {
                return "무엇이든 합니다.~~~";
            }
        };

        System.out.println(beAble.beAble());

        BeAble beAble2 = () ->{
                return "무엇이든 합니다.~~~2222";
            };
            System.out.println(beAble2.beAble());
            //자바스크립트(웹)에서는 화살표 함수로 같은 형식으로 사용됩니다.
        }
    }

    //**함수형 인터페이스 정의** (참고)function 키워드는 c언어,자바스크립트에서 함수 정의에 사용
    //인터페이스 중에 *추상메소드가 1개인 것*은 다른 프로그래밍 언어에서 사용되는 `함수` 의 형식으로 표현할 수 있습니다.
    //      함수와 메소드 공통점은 인자와 리턴값이 있다는 것. 다른 점은 메소드는 클래스(또는 객체)에 구성요소로 포함.
    //      *자바에서 함수형 인터페이스를 익명클래스 형식으로 많이 사용합니다.람다식 사용 가능*

    //자바 라이브러리에는 인자의 형식과 개수와 리턴 타입 등 여러 유형에 따라 
    // Consumer, Producer(자바8까지 이후 Supplier), Function, Predicate 등의
    //      함수형 인터페이스가 미리 정의되어 있습니다.
    //@FunctionalInterface         //함수형 인터페이스에 사용합니다. 애노테이션이라는 주석으로 `코드를 체크하는 기능`을 합니다.
    

