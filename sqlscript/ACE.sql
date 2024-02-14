SELECT * FROM tbl_viewer;
CREATE TABLE tbl_viewer (
   custom_id varchar2(20) PRIMARY KEY ,  
   name varchar2(40) NOT NULL,   
   age number(3) NOT NULL
);

SELECT * FROM tbl_movie;
CREATE TABLE tbl_movie(
   title varchar2(50) PRIMARY KEY ,
   category varchar2(10) NOT NULL,
   view_age NUMBER(10) NOT NULL,
   price number(20) NOT NULL 
);


SELECT * FROM tbl_reserve;
CREATE TABLE tbl_reserve(
   res_idx number(8) PRIMARY KEY ,      
   custom_id varchar2(20) NOT NULL ,         
   title varchar2(50) NOT NULL ,      
   res_date DATE ,
   FOREIGN KEY (custom_id)            
         REFERENCES tbl_viewer(custom_id),   
   FOREIGN KEY (title)
         REFERENCES tbl_movie(title)
);

CREATE SEQUENCE res_pk_seq START WITH 101;

ALTER TABLE TBL_VIEWER ADD password varchar2(20);

INSERT INTO tbl_viewer VALUES ('mond', '이광원', 17,);
INSERT INTO tbl_viewer VALUES ('abcd', '김태완', 14,);
INSERT INTO TBL_VIEWER VALUES('xodbs', '권태윤', 25,);
INSERT INTO TBL_VIEWER VALUES ('chane', '강주찬', 19,);
INSERT INTO tbl_viewer VALUES ('app1e','고길현',17,);

INSERT INTO tbl_movie VALUES ('대충액션영화제목', '액션', 15, 15000);
INSERT INTO tbl_movie VALUES ('대충야한영화제목', '로맨스', 19, 20000);
INSERT INTO tbl_movie VALUES( '서울의봄', '드라마', 19, 30000);
INSERT INTO tbl_movie VALUES( '워낭소리', '기타', 8, 50000);
INSERT INTO tbl_movie VALUES ('어바웃타임', '로맨스', 15, 15000);
INSERT INTO tbl_movie VALUES ('말죽거리 잔혹사', '코미디', 12, 12000);
INSERT INTO TBL_MOVIE VALUES ('너의 결혼식', '로맨스', 12, 15000);
INSERT INTO TBL_MOVIE VALUES ('어스', '공포', 15, 15000);
INSERT INTO tbl_movie VALUES ('샤이닝','공포',19,15000);
INSERT INTO tbl_movie VALUES ('더 넌','공포',19,14000);

INSERT INTO tbl_reserve
VALUES (res_pk_seq.nextval, 'mond' , '대충액션영화제목' ,to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve
VALUES (res_pk_seq.nextval, 'abcd' , '서울의봄' ,to_date('2023-12-10 09:13:30','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve
VALUES (res_pk_seq.nextval, 'abcd' , '워낭소리' ,to_date('2024-03-21 19:53:11','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve
VALUES (res_pk_seq.nextval, 'xodbs' , '어바웃타임' ,to_date('2024-01-01 12:12:12','yyyy-mm-dd hh24:mi:ss') );
INSERT INTO tbl_reserve 
VALUES (res_pk_seq.nextval, 'app1e', '샤이닝', to_date('2024-01-30 14:32:30', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve 
VALUES (res_pk_seq.nextval, 'app1e', '더 넌', to_date('2024-01-16 15:32:41', 'yyyy-mm-dd hh24:mi:ss'));



SELECT PASSWORD
FROM TBL_VIEWER tv
WHERE PASSWORD = '123';


