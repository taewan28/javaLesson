package collection.myapp;

import java.util.Scanner;
import java.util.*;

public class JavaWordApp {
    public static void main(String[] args) {
        //JavaWord 는 단어 객체, JavaWordBook 은 단어장 객체
        //단어장을 시작하는 프로그램입니다.
        //1. 단어장을 생성
        JavaWordbook myBook = new JavaWordbook();

        //2.단어 추가
        JavaWord newWord = new JavaWord("public","공용의",1);
        myBook.addWord(newWord);
        myBook.addWord(new JavaWord("private", "개인적인", 1));
        myBook.addWord(new JavaWord("protected", "보호하는", 1));
        myBook.addWord(new JavaWord("iterate", "반복하다", 3));
        myBook.addWord(new JavaWord("collection", "수집", 2));
        myBook.addWord(new JavaWord("application", "응용프로그램", 2));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));

        //메조장 출력
        myBook.print();

        //3.단어 조회
        //1)영어단어 입력하면 찾아주기
        String findText = "";
        JavaWord result = myBook.searchWord(findText);
        System.out.println(findText + " 조회 결과" + result);

        //2)List<JavaWord> searchWordByLevel(int level) : 레벨로 조회하기
        List<JavaWord> list = myBook.searchWordByLevel(1);
        JavaWordbook.wordListPrint(list);


        //4.단어 삭제
    }
    
}
