UPDATE "TBL_BUY#" SET QUANTITY =4 WHERE BUY_IDX =1004;

5번
답:
SELECT tb.customid,tc.age, tb.pcode
FROM "TBL_BUY#" tb
JOIN "TBL_CUSTOM#" tc
ON tb.customid = tc.CUSTOM_ID
WHERE tc.AGE BETWEEN 20 AND 30
ORDER BY tc.age;

6. 나이가 가장 많은 고객의 고객명, 고객나이,가입일자를 조회하세요.(서브쿼리 사용합니다.)
답:

SELECT tc.name, tc.age,tc.REG_DATE"가입날짜"
FROM "TBL_CUSTOM#" tc
WHERE tc.AGE  
IN (SELECT MAX(age)FROM TBL_CUSTOM);

7. 'hongGD' 가 구매한 상품 금액 합계를 구하세요
답:
SELECT tb.customid, SUM(tp.price*tb.quantity)"구매 금액"
FROM "TBL_BUY#" tb
JOIN "TBL_PRODUCT#" tp
ON tb.pcode = tp.pcode
WHERE tb.customid = 'hongGD'
GROUP BY customid;

8. 이름에 '나나'가 들어가는 회원이 구매한 상품 구매현황을 조회하세요.
아래 데이터 추가 후 실행하세요.
- 회원 : 'NaChoi','최나나','nach@gmail',29,sysdate
- 구매 : 다음시퀀스값,'NaChoi','DOWON123a',2,sysdate
답:
INSERT INTO "TBL_CUSTOM#" tc 
VALUES ('NaChoi','최나나','nach@gmail',29,sysdate);
INSERT INTO "TBL_BUY#" tb 
VALUES (buy2_pk_seq.nextval, 'NaChoi','DOWON123a',2,sysdate);

SELECT tb.customid,tc.name,tb.pcode,tb.quantity,tb.BUY_DATE"구매날짜"
FROM "TBL_BUY#" tb 
JOIN "TBL_CUSTOM#" tc 
ON tb.CUSTOMID = tc.CUSTOM_ID
WHERE tc.name LIKE '%나나';

9. `사과` 단어가 들어간 상품명의 구매현황을을 조회하세요.
고객ID 오름 차순, 고객ID가 같으면 상품코드 오름차순으로 정렬하세요.
아래 데이터 추가 후 실행하세요.
- 상품 : 'BUSA21B','B2','부사 사과 3kg 박스',26000
- 구매 : 다음시퀀스값,'hongGD','BUSA21B',2,'2024-01-03'
답:
INSERT INTO "TBL_PRODUCT#" tp  
VALUES ('BUSA21B','B2','부사 사과 3kg 박스',26000);
INSERT INTO "TBL_BUY#" tb 
VALUES (buy2_pk_seq.nextval,'hongGD','BUSA21B',2,'2024-01-03');

SELECT tb.CUSTOMID, tb.PCODE,SUM(price*quantity)"구매 금액"
FROM "TBL_PRODUCT#" tp 
JOIN "TBL_BUY#" tb 
ON tp.PCODE = tb.PCODE 
WHERE tp.PNAME LIKE '%사과%'
GROUP BY tb.CUSTOMID , tb.PCODE
ORDER BY tb.CUSTOMID , tb.PCODE;


10. 총 구매합산 금액이 10만원 미만인 고객ID를 조회하시오.
답:
SELECT tb.customid, SUM(quantity*price)
FROM TBL_PRODUCT tp 
JOIN "TBL_BUY#" tb 
ON tp.pcode = tb.pcode
GROUP BY tb.customid
HAVING SUM(tp.PRICE * tb.QUANTITY) <100000;

11. 2023년 하반기 구매 건수를 조회하세요.
답:
SELECT SUM(total.total_quantity) AS "구매 건수"
FROM (
    SELECT tb.customid, tb.pcode, SUM(tb.QUANTITY) AS total_quantity
    FROM "TBL_BUY#" tb 
    JOIN "TBL_PRODUCT#" tp ON tb.PCODE = tp.PCODE 
    WHERE BUY_DATE BETWEEN TO_DATE('2023-07-01','yyyy-mm-dd')
    AND TO_DATE('2023-12-31','yyyy-mm-dd')
    GROUP BY tb.CUSTOMID, tb.PCODE
) total
JOIN "TBL_PRODUCT#" tp 
ON total.pcode = tp.pcode;

12. 2024년 1월에 상품을 구매한 고객ID 를 중복없이 조회하세요.
정렬 기준은 고객ID 순서입니다.
답:
SELECT tb.customid
FROM "TBL_BUY#" tb 
WHERE to_char(BUY_DATE,'yyyy-mm')='2024-01'
GROUP BY tb.customid
ORDER BY tb.customid;


13. 진라면 상품코드 'JINRMn5' 을 구매한 고객 ID, 수량,구매 날짜를
조회하세요. 정렬 기준은 빠른 날짜가 먼저 나오게 합니다.
답:
SELECT tc.CUSTOM_ID ,tb.quantity,tb.buy_date"구매 날짜"
FROM "TBL_BUY#" tb 
JOIN "TBL_CUSTOM#" tc 
ON tb.CUSTOMID = tc.CUSTOM_ID 
WHERE tb.PCODE = 'JINRMn5'
ORDER BY buy_date DESC ;

14. 진라면 상품코드 'JINRMn5' 을 구매한 고객들의 평균 나이를
제품코드(PCODE)와 함께출력해 주세요.
답:
SELECT tb.pcode, AVG(tc.age)"구매고객 평균나이"
FROM "TBL_BUY#" tb 
JOIN "TBL_CUSTOM#" tc 
ON tb.CUSTOMID = tc.CUSTOM_ID 
WHERE tb.PCODE = 'JINRMn5'
GROUP BY tb.pcode; 

15. 쇼핑몰 고객의 평균 나이를 구하세요.(보너스 문제)
답:
SELECT AVG(tc.age)"평균나이"
from "TBL_CUSTOM#" tc 

