/*
 		SQL의 집계 함수(개수,최대값,최소값,합계,평균) 함수 - 그룹함수
 											ㄴ GROUP BY 구문에서 
 											ㄴ 집계함수는 다른 컬럼과 함꼐 조회하려면 group by 가 필요합니다.
 
*/

SELECT COUNT(*)"COUNT",SUM(JUMSU)"SUM",AVG(JUMSU) "평균" FROM TBL_SCORE ts ; 
-- 1) '성적' 테이블의 전체 행 개수
SELECT  COUNT(*) AS FROM TBL_SCORE ts ; 

-- 조회된 함수 결과에 컬럼명을 주려면 AS "컬럼명"으로 합니다 (AS 생략 가능)

-- 2) '성적' 테이블의 과목 컬럼 '국어' 값을 갖는 전체 행 개수
SELECT COUNT(*) FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 3) '성적' 테이블의 'jumsu' 컬럼의 합계
SELECT sum(JUMSU) FROM TBL_SCORE ts ;

-- 4) '성적' 테이블의 '국어' 과목 'jumsu' 컬럼의 합계
SELECT sum(JUMSU) FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 5) '성적' 테이블의 'jumsu' 컬럼의 평균
SELECT AVG(JUMSU) FROM TBL_SCORE ts ;

-- 6) '성적' 테이블의 '국어' 과목 'jumsu' 컬럼의 평균
SELECT AVG(JUMSU) FROM TBL_SCORE ts WHERE SUBJECT = '국어' ;

-- 7) '성적' 테이블의 'jumsu' 컬럼의 최대값
SELECT MAX(JUMSU) FROM TBL_SCORE ts ;

-- 8) '성적' 테이블의 '영어' 과목 'jumsu' 컬럼의 최대값
SELECT MAX(JUMSU) FROM TBL_SCORE ts WHERE SUBJECT  = '영어';

--오류 : 집계함수는 다른 컬럼과 함께 조회하려면 group by 가 필요합니다.
--SELECT subject, COUNT(*) FROM TBL_SCORE ts ;
--SELECT subject, COUNT(*) FROM TBL_SCORE ts WHERE  SUBJECT = '국어';

-- GROUP BY SUBJECT 구문이 있으므로 조회 컬럼에 subject 를 추가할 수 있습니다.
SELECT SUBJECT, COUNT(*) FROM TBL_SCORE ts GROUP BY SUBJECT ;

-- GROUP BY SUBJECT 구문이 있으므로 조회 컬럼에 STUNO 를 추가할 수 있습니다.
SELECT STUNO, COUNT(*) FROM TBL_SCORE ts GROUP BY STUNO ; 

SELECT *FROM TBL_SCORE;

--GROUP BY는 그룹화컬럼명1, 그룹화컬럼명2,,..... 로 할수 있습니다.



