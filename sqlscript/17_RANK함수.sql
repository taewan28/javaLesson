/*
	오라클의 RANK 함수
	예제 : 고객-상품별 최대구매금액을 구하고 해당 상품코드 조회하기
		  ㄴ 고객ID로 1차 그룹화, 고객 내에서 상품코드로 2차 그룹화
*/

INSERT INTO TBL_BUY tb VALUES (buy_pk_seq.nextval,'mina012','JINRMn5',13,'2024-01-26');

-- 1) group by
-- 준비
SELECT 
		tb.CUSTOMID , tb.PCODE ,
		sum(tp.PRICE*tb.QUANTITY)-- 가격*수량에 대한 그룹화 함수 sum 실행
FROM 
		TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
		tb.PCODE =tp.PCODE
GROUP BY 
		tb.CUSTOMID , tb.PCODE ;
	
-- 2) 1)번 결과에 정렬 해봅니다.
SELECT 
		tb.CUSTOMID , tb.PCODE ,
		sum(tp.PRICE*tb.QUANTITY)MONEY			-- 가격*수량에 대한 그룹화 함수 sum 실행
FROM 
		TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
		tb.PCODE =tp.PCODE
GROUP BY 
		tb.CUSTOMID , tb.PCODE
ORDER BY 
		tb.CUSTOMID , MONEY DESC;
	
-- 3)1)번 결과에 RANK 함수를 적용해 봅니다.		- RANK() 함수 결과값으로 컬럼을 추가	
SELECT 
		tb.CUSTOMID , tb.PCODE ,
		sum(tp.PRICE*tb.QUANTITY)MONEY			-- 가격*수량에 대한 그룹화 함수 sum 실행
		--,RANK() OVER (ORDER BY sum(tp.PRICE*tb.QUANTITY)DESC) "RANK"		--전체 MONEY 순위
		,RANK() 
			OVER (PARTITION BY tb.CUSTOMID
			ORDER BY sum(tp.PRICE*tb.QUANTITY)DESC) "RANK"		--그룹화 MONEY 순위			
		-- OVER () 안에는 어떤 컬럼으로 정렬해서 순위를 매기는지에 대한 내용.
FROM 
		TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
		tb.PCODE =tp.PCODE
GROUP BY 
		tb.CUSTOMID , tb.PCODE;
	
-- 4) 3)번을 서브쿼리로 하여 rank =1 인 조건을 적용해보기
WITH customSale
AS
(
	SELECT 
		tb.CUSTOMID , tb.PCODE ,
		sum(tp.PRICE*tb.QUANTITY)MONEY,			-- 가격*수량에 대한 그룹화 함수 sum 실행
		RANK() 
			OVER (PARTITION BY tb.CUSTOMID
				  ORDER BY sum(tp.PRICE*tb.QUANTITY)DESC) RANK		--그룹화 MONEY 순위
		FROM 
				TBL_BUY tb ,TBL_PRODUCT tp 
		WHERE 
				tb.PCODE =tp.PCODE
		GROUP BY 
				tb.customid, tb.pcode
)
SELECT *
FROM customSale
WHERE RANK =1;
		
		
