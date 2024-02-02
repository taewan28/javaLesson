/*
PL/SQL : Procedure(절차,순서) Language , 기존의 단순한 SQL이 확장된 언어(SQL로 만드는 프로그램)
         변수,제어문(if,반복문)을 사용하여 프로그래밍언어와 같이 sql 실행의 흐름을 제어
- 구성 : 선언부(DECLARE), 실행부(BEGIN), 예외처리부 (EXCEPTION)로 구성됨
- 유형
	1) Anonymous PL/SQL Block(익명블록) 
	익명 블록은 주로 일회성으로 사용
	2)Stored PL/SQL Block (저장 프로시저)
	서버에 파싱해서 저장해 놓고 주기적으로 반복해서 사용할 경우 사용됨
	서브프로그램 또는 프로그램 단위라고도 하며, 
	스키마를 구성하는 오브젝트로서 파싱된 후 오라클 서버 내부에 저장되거나 오라클 툴 안에 라이브러리 형태로 저장되어 있음

Declare (선언부)
Executable (실행부)
Exception (예외 처리부)
*/
SELECT * FROM TBL_CUSTOM tc ;
-- 1) 익명 프로시저(일회용)
DECLARE   -- 변수선언부  
	-- vname varchar2(40);			 -- 스칼라변수
	-- vage number(3,0);
	vname tbl_custom.name %TYPE;     -- 참조변수(타입변수)
	vage tbl_custom.age %TYPE;
BEGIN		--프로시저 시작(실행부)
  -- 프로시저 내부에는 주로 트랜잭션을 구성하는 여러개의 DML 명령문들을 작성하는 것이 일반적
	SELECT name,age 
		INTO vname , vage	-- 프로시저 구문: 검색결과를 프로시저 일반 변수 vname, vage 에 저장
	FROM "TBL_CUSTOM" tc 
	WHERE CUSTOM_ID ='hongGD';		-- 1개 행만 결과 조회되는 조건
									-- 여러개 행 조회될때는 각 행에 접근하기 위한 cursor 필요.
-- DBMS_OUTPUT 는 콘솔에 출력하는 오라클 패키지의 하나이며 PUT_LINE 함수
	DBMS_OUTPUT.PUT_LINE('고객이름 : ' || vname);  -- ||는 문자열 연결 연산
	DBMS_OUTPUT.PUT_LINE('고객나이 : ' || vage);
	EXCEPTION		-- 예외(오류)처리
	WHEN no_data_found THEN   -- no_data_found : 예외 이름 (정해진 이름), OTHERS : 모든 예외
		DBMS_OUTPUT.PUT_LINE('찾는 데이터가 없습니다.');
END;  --프로시저 끝

/*
	저장 프로시저 생성
	CREATE OR REPLACE PROCEDURE 프로시저 이름
	( 매개변수이름 [IN 또는 OUT] 데이터 타입,.....)		IN: 입력매개변수, OUT: 출력매개변수(리턴값 저장)
	[IS 또는 AS]
		프로시저 변수 선언
	BEGIN
		프로시저 작업 내용 SQL들....

	EXCEPTION 
		WHEN 예외이름 THEN 처리 내용;

	END ;


*/

-- 인자와 리턴을 주는 형식. 저장프로시저 정의하기
CREATE OR REPLACE PROCEDURE search_custom(   -- 프로시저 이름 설정
      c_id IN tbl_custom.CUSTOM_ID %TYPE      -- 매개변수(인자) IN 
)
IS 
   vname tbl_custom.name %TYPE;   -- 지정된 테이블의 컬럼과 동일형식의 변수
   vage tbl_custom.age %TYPE;
BEGIN 
   SELECT name,age 
      INTO vname , vage   
   FROM "TBL_CUSTOM" tc 
   WHERE CUSTOM_ID =c_id;      -- 1개 행만 결과 조회되는 조건. 매개변수로 전달된 값으로 조건 실행
   
   DBMS_OUTPUT.PUT_LINE('고객이름 : ' || vname);  
   DBMS_OUTPUT.PUT_LINE('고객나이 : ' || vage);
   EXCEPTION      -- 예외(오류)처리
   WHEN no_data_found THEN   
      DBMS_OUTPUT.PUT_LINE(CHR(10)||'찾는 데이터가 없습니다.');   
END;   

-- 프로시저 실행
BEGIN 
	search_custom('mina012');
END;

--EXECUTE search_custom('hong');		-- 디비버에서는 실행 안됩니다.

-- 저장프로시저 예제 2
-- 구매 수량이 최대인 고객의 이름, 나이 출력하는 프로시저 : max_custom

--일반적인 SQL은? 구매 수량이 최대=> tbl_buy 테이블, 고객의 이름, 나이=>tbl_custom
SELECT name,age
FROM TBL_CUSTOM tc 
WHERE tc.CUSTOM_ID =(
	SELECT CUSTOMID 
	FROM TBL_BUY tb 
	WHERE tb.quantity = (
		SELECT MAX(quantity)FROM TBL_BUY tb2
	)
);
-- 복습: 프로시저는 SQL로 만든 프로그램.=> 여러 개의 DML로 구성이 됩니다.PLSQL라고 부릅니다.
--						  => 필요에 따라 조회 결과를 저장하는 변수를 사용할 수 있다.



CREATE OR REPLACE PROCEDURE max_custom(	  -- 자바의 메소드 인자와 같은 개념
   p_name OUT tbl_custom.NAME %TYPE,      -- 출력(리턴)값이 있다면 OUT 변수를 사용합니다.
   p_age OUT tbl_custom.AGE %TYPE
)
IS
   maxval number(5);
   cid tbl_custom.custom_id %TYPE;
BEGIN
   SELECT max(quantity)		-- 구매 수량 최대값
      INTO maxval 			-- 조회 결과를 일반변수에 저장
   FROM tbl_buy; 

   SELECT customid
      INTO cid				-- 조회 결과를 일반변수에 저장
   FROM tbl_buy
   WHERE quantity = maxval;

   SELECT name,age 
      INTO p_name , p_age   -- 출력매개변수에 저장
   FROM "TBL_CUSTOM" tc 
   WHERE CUSTOM_ID =cid;
END;

-- 프로시저 실행 : 출력 매개변수가 있는 프로시저
DECLARE 
	vname tbl_custom.name %TYPE;
	vage tbl_custom.age %TYPE;
BEGIN
	max_custom(vname,vage);
	DBMS_OUTPUT.PUT_LINE(CHR(10));
	DBMS_OUTPUT.PUT_LINE('고객이름 : '|| vname);
	DBMS_OUTPUT.PUT_LINE('고객나이 : '|| vage);
END;
