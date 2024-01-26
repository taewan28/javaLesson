REATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY
      INTO v_pcode , v_quantity
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND BUY_DATE = p_date;
   
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
END;


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