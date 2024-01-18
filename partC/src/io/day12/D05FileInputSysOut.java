package io.day12;

import java.io.FileInputStream;
import java.io.IOException;

//파일입력 => 콘솔장치(화면) 출력
public class D05FileInputSysOut {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try{ 
        fis = new FileInputStream("테스트.md");     //UTF-8 인코딩
        int b;
        int count=0;
        //바이트기반의 스트림 read 메소드는 데이터를 1바이트 씩 읽어옵니다.
        while ((b = fis.read())!= -1) {     //파일에 끝을 만나면 -1 입니다.
            System.out.write(b);            //윈도우 터미널 인코딩 방식은 MS949(ANSI형식)
            count++;
        }
        System.out.println("count : " + count);
        } catch (IOException e) {       //FileNotFoundException 의 부모
            System.out.println("파일 입력 중 예외 발생 : " + e.getMessage());
        }finally{
            try{fis.close();}
            catch(IOException e){};
        }
    }
    
}
