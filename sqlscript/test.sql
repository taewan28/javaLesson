-- 테스트 SQL 작성하시면 됩니다.
능력단위 평가 : 데이터베이스 이해와 활용

성명 :  김태완

※ 답안을 모두 작성한 후 PDF 로 변환하여 제출하세요.

1. ER 다이어그램을 참고하여 테이블을 생성하는 SQL문을 작성하고 실행하세요.(20점)
답 : 





2. buy2_pk_seq 이름으로 시퀀스를 만드세요. 시퀀스 값은 1001부터 시작합니다. 
이 시퀀스는 tbl_buy# 테이블의 buy_idx 컬럼 값에 사용됩니다.(5점)
답: 




3. 데이터는 다음과 같이 초기화 하는 SQL을 작성하고 실행하세요. (10점)

TBL_CUSTOM#

단, wonder 의 가입 날짜는 현재날짜와 시간으로 합니다.

TBL_PRODUCT#


TBL_BUY#

단, buy_idx 컬럼값 1008 구매 날짜는 현재 날짜와 시간으로 합니다.


답: 



4. buy_idx 컬럼 1001 번 값의 수량을 4로 변경하는 SQL을 작성하세요.(5점)



[ SELECT 조회 쿼리를 아래 요구 사항에 따라  작성하세요.(각 6 점) ]

주의 :  답안은 SQL 명령문 작성과 실행 조회결과 이미지 첨부 모두 하세요.
제시된 이미지와 같이  출력되는 명령문이 정답입니다.


5. 20대 나이 고객의 구매 상품 코드와 나이를 나이순으로 정렬 조회하세요.

답:
SELECT tb.customid,tc.age, tb.pcode
FROM "TBL_BUY#" tb  
JOIN "TBL_CUSTOM#" tc 
ON tb.customid = tc.CUSTOM_ID
WHERE tc.AGE BETWEEN 20 AND 30 
ORDER BY tb.CUSTOMID;



6. 나이가 가장 많은 고객의 고객명, 고객나이,가입일자를 조회하세요.(서브쿼리 사용합니다.)

답:
SELECT tc.name,tc.age,tc.reg_date"가입날짜"
FROM "TBL_CUSTOM#" tc 
JOIN "TBL_BUY#" tb
ON tb.customid = tc.CUSTOM_ID
ORDER BY tb.CUSTOMID
(SELECT tc.age FROM "TBL_CUSTOM#" WHERE CUSTOM_ID = MAX(tc.AGE));


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
-  회원 : 'NaChoi','최나나','nach@gmail',29,sysdate
-  구매 : 다음시퀀스값,'NaChoi','DOWON123a',2,sysdate

답:
INSERT INTO tbl_product# tp 
VALUES ('BUSA21B','B2','부사 사과 3kg 박스',26000);

INSERT INTO tbl_custom# 
VALUES ( 'NaChoi','최나나','nach@gmail', 29, to_date(sysdate));


9. `사과` 단어가 들어간 상품명의 구매현황을을 조회하세요.
   고객ID 오름 차순, 고객ID가 같으면 상품코드 오름차순으로 정렬하세요.
아래 데이터 추가 후 실행하세요.
- 상품 : 'BUSA21B','B2','부사 사과 3kg 박스',26000
- 구매 : 다음시퀀스값,'hongGD','BUSA21B',2,'2024-01-03'
INSERT INTO tbl_product# tp 
VALUES ('BUSA21B','B2','부사 사과 3kg 박스',26000);
INSERT INTO tbl_buy# 
VALUES (buy2_pk_seq.nextval, 'hongGD','BUSA21B',2,to_date('2024-01-03','yyyy-mm-dd'));


답:




10. 총 구매합산 금액이 10만원 미만인 고객ID를 조회하시오.
답:
SELECT tb.customid, SUM(tp.price*tb.quantity)"구매 금액"
FROM "TBL_BUY#" tb
JOIN "TBL_PRODUCT#" tp 
ON tb.pcode = tp.pcode
--WHERE tb.customid BETWEEN 0 AND 10000
GROUP BY customid;



11. 2023년 하반기 구매 건수를 조회하세요.

답:




12. 2024년 1월에 상품을 구매한 고객ID 를 중복없이 조회하세요.
정렬 기준은 고객ID 순서입니다.

답:



13. 진라면 상품코드 'JINRMn5' 을 구매한 고객 ID, 수량,구매 날짜를 조회하세요. 정렬 기준은 빠른 날짜가 먼저 나오게 합니다.

답:


14. 진라면 상품코드 'JINRMn5' 을 구매한 고객들의 평균 나이를 제품코드(PCODE)와 함께출력해 주세요.

답:


15. 쇼핑몰 고객의 평균 나이를 구하세요.(보너스 문제)

답:
SELECT AVG(AGE) 
FROM "TBL_CUSTOM#" tc 




