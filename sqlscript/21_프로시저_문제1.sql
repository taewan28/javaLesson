/*
	프로시저 직접 만들어보기 : money_of_day
	매개변수 IN : 고객ID, 날짜(패턴은 'yyyy-mm-dd')
	매개변수 OUT : IN으로 받은 값들을 tbl_buy 에서 상품코드를 조회하여 '총 구매 금액'을 구합니다.
	
				※단, 고객은 1일 1품목만 구매 가능합니다. ※
		1)		고객ID, 날짜 값으로 구매 테이블에서 수량과 pcode 조회하고 변수에 저장하기
		2)		1) 에서 구한 pcode 의 가격을 조회하여 저장하기
		3)		2)번 가격과 1)번 수량을 곱하기 하여 결과값을 변수에 저장 => 출력변수
				곱셈 수식만 계산할 때에는 dual 임시 테이블로 합니다.
	
	프로시저 실행
*/	

	DECLARE
		vmoney number(8);
		vid varchar2(20);
		vdate varchar2(20);
	BEGIN
		vid :='mina012';
		vdate := '2023-11-10';
		money_of_day(vid,vdate,vmoney);
		money_of_day(char(10) || '고객ID : '|| vid || '날짜:'|| vdate);
		dbms_output_put_line('고객님의 구매금액은' || vmoney ||'입니다.');
	END;
	
CREATE OR REPLACE PROCEDURE proc_set_money(	  
	acustom_id IN p_buy.CUSTOMID %TYPE, --  회원ID		-- 입력 매개변수 IN
	apcode IN p_buy.PCODE %TYPE, 	-- 상품코드
	acnt IN p_buy.QUANTITY %TYPE,
	adate IN p_buy.BUY_DATE %TYPE,
	isSuccess OUT varchar2  -- 출력 매개변수 OUT. 트랜잭션 처리 성공여부 저장.
)
IS 
	vmoney number;
	vid varchar2;
	vdate varchar2;
BEGIN 
	INSERT INTO p_buy(buy_IDX,CUSTOMID,PCODE,QUANTITY,BUY_DATE)
		values (pbuy_seq.nextval, acustom_id,apcode,acnt,sysdate); 
	--1)
	SELECT  PCODE, QUANTITY
		INTO vpcode,vQuantity
		FROM TBL_BUY
		WHERE CUSTOMID = vmoney AND to_char(BUY_DATE,'yyyy-mm-dd')=입력변수IN;
	--2)
	SELECT pcode
	INTO ?
	FROM TBL_PRODUCT tp 
	WHERE PCODE = 1)번에서 구한값 변수
	
	--3) 출력매개변수에 저장하기
	SELECT 1)번에서 구한 수량값 변수 * 2)번에서 구한 가격값 변수
	INTO ?
	FROM dual;