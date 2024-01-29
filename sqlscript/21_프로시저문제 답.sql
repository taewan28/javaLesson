CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY			-- 1일 1구매 조건으로 오직 1개의 행이 조회됩니다.
      INTO v_pcode , v_quantity		-- 조회 결과가 n개의 행이면 프로시저의 커서 기능을 이용합니다.(나중에 진도 나갑니다)
      --	INTO 는 프로시저에서만 사용합니다. 조회 결과를 변수에 저장합니다.
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND to_char(BUY_DATE,'yyyy-mm-dd') = p_date;
   -- 테스트를 위해 확인 출력
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;		--수량*가격 수식 연산결과를 출력매개변수 p_money 에 저장
   					--특정 테이블과 상관 없으므로 dual 임시 테이블 사용하여 저장
  
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION	-- 프로시저에서는 조회 결과가 없는 겨우 예외로 처리할 수 있습니다.
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE(CHR(10) || '조건에 맞는 데이터가 없습니다.');
   p_money :=0;
END;

SELECT  PCODE, QUANTITY
		FROM TBL_BUY
		WHERE CUSTOMID ='mina012' AND to_char(BUY_DATE,'yyyy-mm-dd') = '2023-11-10';


DECLARE
		vmoney NUMBER(10);				--프로시저 실행결과 OUT 매개변수값 저장.
		vid tbl_custom.custom_id %TYPE;				-- 프로시저 실행에 필요한 IN 매개변수값 저장변수
		vdate varchar2(20);				-- 없어도 되지만 출력 등 편의상 선업합니다.
	BEGIN
		vid :='mina012';
		vdate := '2023-11-11';
		money_of_day(vid,vdate,vmoney);
		-- vid, vdate IN 매개변수값으로 프로시저를 실행합니다.
		-- OUT 매개변수에 저장된 프로시저 실행 결과를 vmoney 변수에 저장합니다.
		dbms_output.put_line(CHR(10) || '고객ID : '|| vid || ' 날짜: '|| vdate);
		dbms_output.put_line('고객님의 구매금액은' || vmoney ||'입니다.');
	END;
	
--tbl_custom.custom_id %TYPE

