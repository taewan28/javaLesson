CREATE TABLE TBL_EXCUSTOMER (
	id varchar2(7) PRIMARY KEY,    
	name varchar2(30) NOT NULL,  
	email nvarchar2(100),
	age number(3) CHECK (age BETWEEN 10 AND 50),
	join_date DATE default sysdate 
);

SELECT *FROM TBL_EXCUSTOMER;
DROP TABLE TBL_EXCUSTOMER;

INSERT INTO TBL_EXCUSTOMER VALUES ('mina012', '김미나', 'kimm@gmail.com', 20,
						to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXCUSTOMER VALUES ('hongGD', '홍길동', 'gil@korea.com', 32,
						to_date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXCUSTOMER VALUES ('twice', '박모모', 'momo@daum.net', 29,
						to_date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXCUSTOMER(id,name,email,age) VALUES ('wonder', '이나나', 'lee@naver.com', 40);
					


CREATE TABLE TBL_EXPRODUCT(
	productcode varchar2(10) PRIMARY KEY,
	groupname char(2) NOT NULL,	
	productname nvarchar2(20) NOT NULL ,
	cost number(6) NOT NULL
);

SELECT *FROM TBL_EXPRODUCT;
DROP TABLE TBL_EXPRODUCT;

INSERT INTO TBL_EXPRODUCT VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO TBL_EXPRODUCT VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO TBL_EXPRODUCT VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO TBL_EXPRODUCT VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO TBL_EXPRODUCT VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);

CREATE TABLE TBL_EXBUY (
	id varchar2(12),    
	productcode varchar2(12) NOT NULL,  
	buy_count number(6) NOT NULL,
	buy_date DATE default sysdate,
	PRIMARY KEY(id,productcode),
	FOREIGN KEY
			(id)
	REFERENCES 
			TBL_EXCUSTOMER(id)
);		

INSERT INTO TBL_EXBUY VALUES ('mina012' , 'CJBAb12g' , 5 ,
						to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('mina012' , 'APLE5kg' , 2 ,
						to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('mina012' , 'JINRMn5' , 2 ,
						to_date('2022-03-16 10:13:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('twice' , 'JINRMn5' , 3 ,
						to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('twice' , 'MANGOTK4r' , 2 ,
						to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('hongGD' , 'DOWON123a' , 1 ,
						to_date('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_EXBUY VALUES ('hongGD' , 'APLE5kg' , 1 ,
						to_date('2022-04-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
					
-- 구매 테이블에 기본키 만들기
-- 1)기본키에 들어갈 값은 시퀀스로 만듭니다. exbuy_pk_seq 시작값은 1001로 합니다
CREATE  SEQUENCE exbuy_pk_seq START WITH 1001;
					
-- 2) 기본키 컬럼을 buy_idx 로 하여 컬럼추가. number(8)
ALTER TABLE TBL_EXBUY ADD buy_idx number(8);
					
							
-- 3) 기본 행에 적용할 buy_idx 컬럼값을 저장하기. not null과 unique 적용하여 설정하기

-- 4) buy_idx 컬럼에 대해 primary 키 설정하기
ALTER TABLE TBL_EXBUY ADD CONSTRAINT tal_exbuy_pk PRIMARY KEY (buy_idx);

-- 5) 이제부터 새로운 행을 추가할 떄에는 시퀀스 함수로 pk 값을 insert 합니다.
INSERT INTO TBL_EXBUY (buy_idx,id,productcode,buy_count)VALUES (exbuy_pk_seq.nextval,'mina012' , 'CJBAb12g' , 5);
SELECT *FROM TBL_EXBUY te ;



SELECT *FROM TBL_EXBUY;
DROP TABLE TBL_EXBUY;

SELECT * FROM TBL_EXBUY WHERE id = 'mina012';

--문제 :구매내역중 g가 포함된 상품코드 출력하시오.
SELECT * FROM TBL_EXBUY WHERE productcode LIKE '%g';




