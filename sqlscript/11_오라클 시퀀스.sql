/*
	시퀀스 : 오라클의 객체. 값을 자동으로 만들어 줍니다. 일련번호로 사용하는 값에 사용.
			행을 식별하는 목적으로 사용하는 값. (mysql 은 auto increment 속성으로 사용)

*/

-- 1. 시퀀스 생성하기
CREATE  SEQUENCE test_seq;


-- 2. 시퀀스 사용을 위한 함수 : nextval(다음 시퀀스 값) 와 currval(현재 시퀸스 값)

SELECT TEST_SEQ.nextval FROM dual;

-- 현재시퀀스값은 nextval 을 처음 한번 꼭 실행한 후에 (값이 만들어진 후) 실행 가능
SELECT TEST_SEQ.currval FROM dual;

-- 3. 시퀀스 시작값을 바꾸기
CREATE  SEQUENCE test_seq2 START WITH 2001;

-- 4. 증가값 바꾸기
CREATE SEQUENCE test_seq3 INCREMENT BY 5;
SELECT test_seq3.nextval FROM dual;