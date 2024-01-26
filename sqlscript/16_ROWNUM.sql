/*
 * 		오라클 ROWNUM 컬럼 : 오라클이 select 결과에 부여하는 행번호
 * 						  오라클이 내부적으로 관리를 위한 컬럼
 * 
 */
-- 1) 상품테이블의 상품 가격을 내림차순으로 정렬하여 조회
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC;

-- 2) rownum 컬럼을 출력해봅시다.
SELECT rownum, tp.*
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC;

-- 3)서브쿼리로 변경
SELECT rownum , tp.*
FROM (
		SELECT *
		FROM TBL_PRODUCT tp 
		ORDER BY PRICE DESC
	) tp;
	
-- 4) 위의 3번 결과에 rownum 조건을 적용해봅니다.
SELECT rownum , tp.*
FROM (
		SELECT *
		FROM TBL_PRODUCT tp 
		ORDER BY PRICE DESC
	) tp
--WHERE rownum =1; 	-- 잘 실행됩니다.
WHERE rownum =3 ;		-- 실행 안됩니다. 가능한 조건식은 rownum이 1이 포함되는 경우만 가능
 
-- 5) 중간 일부를 가져오기 위해서 between ~ and ~ 연산으로 합니다. 단, 4)번을 대상으로 서브쿼리를 또 써야 합니다.
-- 예시 : 게시판의 글목록에 대해 페이지 번호 적용합니다.
SELECT *
FROM (
		SELECT rownum r , tp.*		-- rownum 에 대한 별칭이 필요합니다.
		FROM (
			SELECT *
			FROM TBL_PRODUCT tp 
			ORDER BY PRICE DESC
			 ) tp
	 )
WHERE 
		r BETWEEN 2 AND 4;
-- 6) 오라클 12C 버전부터는 FRTCH 명령이 있습니다.
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC 
FETCH FIRST 2 ROWS ONLY ;		-- top 2(n) 가져오기 

	

 
 
 