/*
	서브 쿼리(sub query) : select 조회 결과(여러개의 행)가 다른 DML 명령어에 쓰일 수 있습니다.
													  ㄴ select, insert,update,delete
						select, insert,update,delete 에 포함되는 select 를 서브 쿼리라고 합니다.
	select 함께 쓰이느 서브쿼리
					  : select 컬럼1,컬럼2 from (select....)
					  					where 컬럼명1=값(select....)
	select 서브쿼리는 join으로도 가능합니다.						
**/

-- 1) where 에서 쓰는 서브쿼리 : twice 가 구매한 상품 정보
-- JOIN
SELECT tb.*
FROM TBL_PRODUCT tp ,TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE 				--1) 크로스 연산
AND tb.CUSTOMID = 'twice';				--2) 조건식 연산

-- 서브쿼리
SELECT tp.*
FROM TBL_PRODUCT tp 
WHERE PCODE IN						--2) 조건식 연산
-- ('CJBAb12g','APLE5kg','DOWON123a')
(SELECT PCODE FROM TBL_BUY tb WHERE CUSTOMID = 'twice'); --1) 조건식 연산

--2) from 에서 사용되는 서브 쿼리 : 컬럼명 또는 테이블명 별칭을 줄때 한글을 쓰려면 ""안에 사용합니다.
SELECT
		saleMoney.PCODE,SUM(QUANTITY),SUM("구매 금액") 
FROM 
		(SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
		FROM TBL_PRODUCT tp ,TBL_BUY tb 
		WHERE tp.PCODE = tb.PCODE) saleMoney
GROUP BY saleMoney.PCODE;

-- 서브쿼리 없이
SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS TotalQuantity,
    SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;


-- 오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다.
WITH saleMoney
AS
(SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
		FROM TBL_PRODUCT tp ,TBL_BUY tb 
		WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.PCODE,SUM(saleMoney.QUANTITY),SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.pcode;


-- 서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요.


-- with 구문이용하여 saleMoney를 그룹으로 묶고 그 중 구매합산 금액 중 20000~70000사이 값을 출력하시오.
WITH saleMoney
AS
(SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
		FROM TBL_PRODUCT tp ,TBL_BUY tb 
		WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.PCODE,SUM(saleMoney.QUANTITY),SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.pcode
HAVING SUM("구매 금액") BETWEEN 100000 AND 200000;

/* 고객별로 구매금액이 가장 높은 상품코드를 조회하세요.
 * 	ㄴ 오라클 RANK 함수 (그룹화 결과에 대한 순위를 제공)
 * 
 * 내림차순 또는 오름차순 정렬된 결과에서 top3 조회하기 
 */

--서브쿼리 없이 변경
SELECT 
    tb.CUSTOMID,
    SUM(tb.QUANTITY) AS TotalQuantity,
    SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount    
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tb.CUSTOMID
HAVING 
	SUM(tp.PRICE * tb.QUANTITY) BETWEEN 100000 AND 200000; 







