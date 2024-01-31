--JDBC 프로젝트를 위한 SQL테스트
--SQL테스트 후 자바 프로그래밍 하기   

-- 회원 정보 수정 : email, age
UPDATE TBL_CUSTOM 
SET EMAIL ='test@gmail.com', age=22
WHERE CUSTOM_ID = 'nayeon3';

--회원 탈퇴 :
DELETE FROM TBL_CUSTOM tc 
WHERE CUSTOM_ID = 'almond';

--회원 조회
select * from tbl_custom where custom_id = 'sana';

-- 주요 정리 : 컬럼 조회한 결과는 1개 또는 1개 이상에 따라 리턴 형식을 결정 하자(List ? Not List?)
--상품 검색하기 SQL : ProductVo, TblProductDao 만들기
--									ㄴ SELECTByCategory, selectByPname 메소드 만듭시다.

--카테고리로 검색하기
-- 1) 어떤 카테고리가 있는지 보여주기
SELECT DISTINCT CATEGORY  FROM TBL_PRODUCT tp ;			--중복된 값은 한번만.(중복제거)
-- 2) 특정 카테고리에 대해 상품 목록 보여주기		-조회 결과는 1 or N개
SELECT *FROM TBL_PRODUCT tp 
WHERE CATEGORY = 'B1';

-- 데이터 추가ㄴㄴ
INSERT INTO TBL_PRODUCT tp 
VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);

-- 3) 상품명 유사(like) 검색
SELECT *FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%'||'사과'||'%';	--프로그램에서 매개변수 자리를 위해 연결 연산으로함

-- MyPage 기능의 메소드를 위한 SQL
-- selectCustomerBuyList => TblBuyDao 에 만드세요.
--						 => 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVo를 만들어야 합니다.
SELECT BUY_IDX , tb.PCODE ,PNAME, PRICE, QUANTITY, BUY_DATE 
FROM TBL_BUY tb
JOIN TBL_PRODUCT tp 
ON tb.PCODE = tp.PCODE
WHERE tb.CUSTOMID = 'mina012';		-- 'mina012'는 SQL 매개변수 입니다



