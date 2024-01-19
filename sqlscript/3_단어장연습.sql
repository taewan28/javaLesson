/*
 *  '단어장' 프로그램을 위한 테이블
 * 0.테이블명 : tbl_javaword
 * 1. 테이블 구조
 * 												3.To do : 컬럼값들의 규칙	-> 요구사항에 대한 제약조건
 * 		idx			number(8)					같은 값을 가질수 없다. 반드시 값이 있어야한다.
 * 		english		varchar2(1000)				같은 값을 가질수 없다. 반드시 값이 있어야한다.
 * 		korean		nvarchar2(100)				반드시 값이 있어야한다.
 * 		step		number(1)					반드시 값이 없는 null 도 가능하다.1~4 범위로만 한다.
 * 												
 * 		4.To do : 검색 속도 향상시키기 위한 컬럼을 정해라.데이터행을 식별할 수있는 컬럼을 정해라(기본키 설정)
 * 
 * 2. 테이블에 행 추가 - 데이터 입력하기
 * 
 * **** 오라클의 키워드는 테이블명, 컬럼명으로 사용 못합니다.
 */

CREATE TABLE tbl_javaword(
	idx number(8),			 
	english varchar2(1000),			
	korean nvarchar2(100),		
	step number(1)	
);

INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (1,'kimt','김',1);
INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (2,'tae','태',2);
INSERT INTO TBL_JAVAWORD(idx,english,korean) VALUES (3,'wan','완');  		--입력하지 않은 컬럼 step 의 값은 null
INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (4,'park','박',1);
INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (5,'ki','기',2);

-- SELECT 컬럼명1,컬럼명2,... FROM 테이블명  => 모든 컬럼을 지정하는 문자는 *(와일드카드 문자)
SELECT * FROM TBL_JAVAWORD;

-- SELECT 컬럼명1,컬럼명2,...FROM 테이블명 WHERE 컬럼명 = 값 		=> 특정 컬럼을 조건식으로 조회
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NOT NULL;
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NULL;
SELECT * FROM TBL_JAVAWORD WHERE IDX =2;
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='tae';
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='tae' AND STEP =2;		--AND : 논리연산
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%i%';				--i로 끝나는, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%im%';				--im로 끝나는, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE IDX NOT BETWEEN 10 AND 20;				--10~20 범위값이 아닌것

-- 새로운 연산자
INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (5,'constraint', '제약사항',3);
INSERT INTO TBL_JAVAWORD(idx,english,korean,step) VALUES (9,'order', '순서',1);

-- idx 값이 2,5,9 인  것만 조회
SELECT * FROM TBL_JAVAWORD WHERE IDX = 2 OR IDX = 5 OR IDX = 9;
SELECT * FROM TBL_JAVAWORD WHERE IDX IN (2,5,9);   -- OR 연산을 간단하게

-- idx 값이 2~5 조회
SELECT * FROM TBL_JAVAWORD WHERE IDX  >= 2 AND IDX <= 5;    -- AND 연산은 between으로 간단하게

-- select 컬럼명 1, 컬럼명 2... from 테이블명
--                     [Where 컬럼명 = 값]   => 특정 컬럼을 조건식으로 조회
--                     [order by 컬럼명 1, 컬럼명 2 [DESC]]
--                      = > 지정된 컬럼명으로 정렬. DESC 는 내림차순. ASC 오름차순(생략). 컬럼명 1이 같은 값이면 컬럼명 2로 정렬

SELECT * FROM TBL_JAVAWORD
       WHERE IDX IN (2, 5, 9)
       ORDER BY IDX , KOREAN;      -- idx 1차 정렬 컬럼, KOREAN 2차 정렬 컬럼
       
INSERT INTO TBL_JAVAWORD VALUES (2,'prvate','사적인',1);


