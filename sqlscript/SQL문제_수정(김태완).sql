/* 첨부된 이미지 파일은 각 문제의 실행결과입니다. 실행 결과를 참고하여 SQL문을 작성하세요.
 * 3개의 예시 테이블의 데이터를 첨부된 이미지와 동일하게 초기화하여 실행하세요.
 * 답을 첨부한 문제룰 참고하여 나머지 문제를 풀어보세요. */


/* A조  */
--A-1. 'mina012' 가 구매한 상품 금액 합계(이광원)
SELECT CUSTOMID  ,SUM(PRICE * QUANTITY) "구매 금액"
	FROM  TBL_PRODUCT tp
	JOIN  TBL_BUY tb 
	ON tp.PCODE = tb.PCODE
	AND CUSTOMID ='mina012'
	GROUP BY CUSTOMID  ;

--A-2. 이름에 '길동'이 들어가는 회원 구매한 상품 구매현황 (권태윤)
SELECT tb.CUSTOMID ,NAME, PCODE ,QUANTITY,BUY_DATE  
	FROM TBL_BUY tb 
	JOIN TBL_CUSTOM tc 
	ON tb.CUSTOMID = tc.CUSTOM_ID 
	WHERE tc.NAME LIKE '%길동';

-- 데이터 추가 후 실행하세요.
INSERT INTO TBL_CUSTOM ssSS
			VALUES ('dongL','이길동','lee@daum.net',25,sysdate);
INSERT INTO TBL_BUY 
			VALUES (buy_pk_seq.nextval,'dongL','DOWON123a',2,sysdate);
			
--A-3. `25살`이상 고객님들의 `구매`한 `상품명` 조회하기 (강주찬) => 테이블 3개
SELECT CUSTOMID , tc.AGE , PNAME 
	FROM TBL_CUSTOM tc  
	JOIN TBL_BUY tb
	ON tc.CUSTOM_ID = tb.CUSTOMID
	JOIN TBL_PRODUCT tp 
	ON tb.PCODE = tp.PCODE
	WHERE tc.AGE > 25;		

--A-4. 상품명에 '사과' 단어가 포함된 상품을 구매한 고객에 대해 상품별 구매금액의 합을 구하기.(고길현)
SELECT tb.CUSTOMID , tb.PCODE , sum(QUANTITY*PRICE)
	FROM TBL_BUY tb 
	JOIN TBL_PRODUCT tp 
	ON tb.PCODE = tp.PCODE
	WHERE tp.PNAME LIKE '%사과%'
	GROUP BY CUSTOMID , tb.PCODE ;
-- 데이터 추가 후 실행하세요.
INSERT INTO TBL_PRODUCT
			VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);
INSERT INTO TBL_BUY  
			VALUES (buy_pk_seq.nextval,'hongGD','BUSA211',2,'2024-01-03');

--A-5. 총 구매합산 금액이 100000~200000 값인 고객 ID를 조회하시오.(김태완)
SELECT 
    tb.CUSTOMID,
    SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount    
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tb.CUSTOMID
HAVING 
	SUM(tp.PRICE * tb.QUANTITY) BETWEEN 100000 AND 200000; 



/*  B조 */
--B-1. 20대 나이 고객의 구매 상품 코드와 나이를 나이순으로 정렬 조회 (이대환) /* C조 조이루 */
SELECT tb.CUSTOMID, tc.age ,tb.pcode 
FROM TBL_CUSTOM tc  
LEFT JOIN TBL_BUY tb
ON tc.CUSTOM_ID = tb.CUSTOMID 
WHERE tc.age BETWEEN 20 AND 30
ORDER BY age;


--B-2. 나이가 가장 많은 고객이 상품을 구매한 횟수를 조회하세요.-서브쿼리 사용하기 (김승한)
SELECT COUNT(*) 
FROM TBL_BUY tb 
WHERE tb.CUSTOMID IN (
SELECT tc.custom_id
FROM TBL_CUSTOM tc WHERE tc.age =(SELECT MAX(age)FROM TBL_CUSTOM));

--B-3. 2023년 하반기 구매금액을 고객ID별로 조회하시오. 금액이 높은 순서부터 조회하세요. (노희영)
SELECT total_sum.CUSTOMID,SUM(total_sum.total_quantity*PRICE) 
FROM (
		SELECT tb.CUSTOMID,tb.pcode, SUM(QUANTITY) AS total_quantity
		FROM TBL_BUY tb
		JOIN TBL_PRODUCT tp
		ON tb.PCODE = tp.PCODE 
		WHERE BUY_DATE BETWEEN TO_DATE('2023-07-01','yyyy-mm-dd')
		AND TO_DATE('2023-12-31','yyyy-mm-dd')
		GROUP BY tb.PCODE,tb.customid
) total_sum
JOIN TBL_PRODUCT tp 
ON total_sum.pcode = tp.PCODE
GROUP BY total_sum.customid;
--ORDER BY SUM(total_sum.total_quantity*PRICE) DESC;

--B-4. 2024년에 구매횟수가 1회 이상인 고객id, 고객이름, 나이,이메일을 조회하세요.(이재훈)
SELECT custom_id,name,age,email 
FROM TBL_CUSTOM tc 
WHERE CUSTOM_ID IN (
		SELECT tb.CUSTOMID
		FROM TBL_BUY tb 
		WHERE to_char(BUY_DATE,'yyyy')='2024'
		GROUP BY tb.CUSTOMID 
		HAVING COUNT(*) >=1
	); 

--B-5. 고객별-상품별 구매금액을 조회하세요. 정렬도 고객ID,상품코드 오름차순으로 정렬하세요.(이예진)
WITH saleMoney
AS
(SELECT tb.customid,tb.PCODE,tb.QUANTITY, tp.PRICE, tb.QUANTITY*PRICE AS "구매 금액" 
		FROM TBL_PRODUCT tp ,TBL_BUY tb 
		WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.customid,saleMoney.PCODE,SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.CUSTOMID,saleMoney.PCODE
ORDER BY saleMoney.customid,saleMoney.PCODE;


/* C조 */
--C-1. 가격 1만원 이상의 상품에 대해 각각 고객들이 구매한 평균 개수를 출력하시오.상품코드 순서로 정렬 (임현범)
SELECT tp.PCODE, tp.PNAME "상품명", avg(tb.QUANTITY) "평균 구매 개수"
	FROM TBL_BUY tb 
	JOIN TBL_PRODUCT tp 
	ON tb.PCODE = tp.PCODE
	--WHERE tp.PRICE >= 10000
	GROUP BY tp.pcode, tp.PNAME
	ORDER BY tp.PCODE 
	;

--C-2. 진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자. (출제자 : 전예진)
SELECT tc.CUSTOM_ID ,tc.name,tb.quantity,tb.buy_date
	FROM TBL_BUY tb
	JOIN TBL_CUSTOM tc
	ON tb.CUSTOMID = tc.CUSTOM_ID 
	WHERE tb.PCODE IN 
	(SELECT PCODE FROM tbl_product WHERE pname LIKE '%진라면%');

--C-3. B조 1번 유사 문제 (조이루)

--C-4. 2023년에 팔린 상품의 이름과 코드,총 판매액 그리고 총 판매개수를 상품코드 순서로 정렬하여 조회하시오. (정제원)
SELECT tp.PCODE , tp.PNAME , pbuy.total_quantity, pbuy.total_quantity*PRICE 
FROM (
		SELECT PCODE, SUM(QUANTITY) AS total_quantity
		FROM TBL_BUY
		WHERE to_char(BUY_DATE,'yyyy')='2023'
		GROUP BY PCODE 
) pbuy
JOIN TBL_PRODUCT tp
ON pbuy.PCODE = tp.PCODE
ORDER BY pbuy.pcode;

--C-5. 'twice'와 'hongGD'는 한집에 살고 있습니다. 이들이 구매한 상품,수량,가격을 조회하세요.-가격이 높은순서부터 정렬 (장성우)
WITH minaGD
as(
	SELECT *
	FROM TBL_BUY tb 
	WHERE CUSTOMID = 'twice' OR  CUSTOMID ='hongGD' 
)
SELECT tp.PNAME, minaGD.quantity,tp.PRICE 
FROM minaGD
JOIN TBL_PRODUCT tp
ON minaGD.PCODE = tp.PCODE 
ORDER BY price desc
;

/* D조 */
--D-1. 진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와 총 진라면 구매금액을 보여주세요.(조하연)
-- 							ㄴ 서브쿼리 없이 조인만 사용
SELECT tb.customid, tb.quantity * tp.price  AS sum
   FROM TBL_PRODUCT tp,
       tbl_buy tb
   WHERE   tp.pcode = tb.pcode
      AND tp.pcode = 'JINRMn5'
  ORDER BY SUM DESC;    
		
--D-2. 판매 갯수가 가장 많은 순서로 상품(상품코드와 상품이름 그룹화)을 정렬하고 총 팔린 금액을 출력하시오.(한진만)
-- 	 판매 개수가 같으면 상품 코드 순서로 정렬합니다.			ㄴ 동등 조인으로 조회
SELECT tp.PCODE , tp.PNAME , pbuy.total_quantity, pbuy.total_quantity*PRICE 
FROM (
		SELECT tp.PNAME ,tb.PCODE, SUM(QUANTITY) AS total_quantity
		FROM TBL_BUY tb
		JOIN TBL_PRODUCT tp
		ON tb.PCODE = tp.PCODE  
		GROUP BY tb.PCODE,tp.PNAME 
) pbuy
JOIN TBL_PRODUCT tp
ON pbuy.PCODE = tp.PCODE
ORDER BY total_quantity DESC,tp.PCODE;

--D-3. 진라면을 구매한 고객들의 평균 나이를 제품코드(PCODE)와 함께출력해 주세요.(황병훈)
SELECT tb.PCODE, AVG(tc.AGE) 
	FROM TBL_BUY tb
	JOIN TBL_CUSTOM tc
	ON tb.CUSTOMID = tc.CUSTOM_ID 
	WHERE tb.PCODE IN 
	(SELECT PCODE FROM tbl_product WHERE pname LIKE '%진라면%')
	GROUP BY tb.PCODE ;


--D-4. 30세 미만 회원별 구매금액을 구하고 회원으로 그룹바이해서 구매금액 합계가 큰 순으로 정렬(조지수)
-- 						ㄴ 3개의 테이블 조인
SELECT abc.CUSTOMID, sum(pay_sum) AS total
FROM
   (
      SELECT tb.customid, tp.price * tb.quantity  AS pay_sum
      FROM  TBL_PRODUCT  tp, TBL_buy tb
      JOIN TBL_CUSTOM tc ON tb.CUSTOMID = tc.CUSTOM_ID AND age<30
      WHERE tp.pcode = tb.pcode
   ) abc
GROUP BY abc.CUSTOMID
ORDER BY total DESC;
-- 또는
SELECT CUSTOMID , sum(QUANTITY*price) total
	FROM TBL_BUY tb ,TBL_PRODUCT tp 
	WHERE tb.pcode = tp.pcode
			AND tb.CUSTOMID IN 
							  (
							  SELECT CUSTOM_ID 
							      FROM TBL_CUSTOM tc 
							      WHERE  age<30
						      )
	GROUP BY CUSTOMID
	ORDER BY total desc;

--D-5. A조 5번  유사 문제 (김태완)
--D-6. D조 1번  유사 문제 (차정호)
 