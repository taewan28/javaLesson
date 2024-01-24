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

/*
 * 집계함수 count, avg , sum, min, max 등 그룹 함수라고도 합니다. 
 * 그룹화 - 지정한 컬럼값이 같을 것을 갖는 행에 대해 집계 함수를 실행합니다.
 *      
 * 
 * select 
 *       그룹화컬럼, 그룹함수
 * from 테이블이름
 * [WHERE] 그룹화하기 이전의 조건식
 * GROUP BY 그룹화에 사용할 컬럼명
 * [HAVING] 그룹화 후에 그룹화 결과값을 사용하는 조건식
 * [ORDER BY] 정렬 컬럼
 */
--GROUP BY는 그룹화컬럼명1, 그룹화컬럼명2,,..... 로 할수 있습니다.

-- 예시 1: 학번(학생)별로 수강한 갯수와 평균을 조회 해보세요
SELECT STUNO, count(*),AVG(jumsu)
FROM TBL_SCORE ts 
GROUP BY STUNO; 

-- 예시 2: 위의 결과에 대해 평균이 80점 미만인 학번(학생)을 조회해 보시오.
SELECT STUNO , COUNT(*),AVG(jumsu)
FROM TBL_SCORE ts 
GROUP BY STUNO
HAVING  AVG(JUMSU)<80; 						-- HAVING 은 집계함수 결과에 대한 조건식입니다.
											
-- 예를 들어서 점수가 80점 이상 데이터만 예시 1번을 실행하도록 한다면 where jumsu >= 80 group by stuno
SELECT STUNO, count(*),AVG(jumsu)
FROM TBL_SCORE ts 
WHERE jumsu >=80
GROUP BY STUNO;

-- 예시 4: 예시 1번의 결과를 평균 내림차순으로 조회하세요
SELECT STUNO, count(*),AVG(jumsu) "학생별 평균"		--평균 함수 결과에 대한 컬럼명 별칭
FROM TBL_SCORE ts 
GROUP BY STUNO
ORDER BY "학생별 평균" DESC;
	--AVG(JUMSU) DESC;

-- 예시 5: 학기-교사별 count, avg 조회하기
SELECT TERM ,TEACHER ,COUNT(*),AVG(JUMSU)  
FROM TBL_SCORE ts 
GROUP BY term, TEACHER;			--먼저 학기별로 그룹하고 2차로 학기가 같은 결과안에서 선생님별로 그룹화
-- 제대로 된 결과를 보려면 데이터가 좀 많아야 합니다.



