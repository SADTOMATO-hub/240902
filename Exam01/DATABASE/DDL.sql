create table BOOK_TBL_06(
 BOOK_NO NUMBER NOT NULL 
,BOOK_NAME VARCHAR2(50) NOT NULL
,BOOK_COVERIMG VARCHAR2(20) 
,BOOK_DATE DATE 
,BOOK_PRICE NUMBER 
,BOOK_PUBLISHER VARCHAR2(50) 
,BOOK_INFO VARCHAR2(2000) );

ALTER TABLE BOOK_TBL_06 ADD CONSTRAINT book_pk PRIMARY KEY (BOOK_NO);

--DROP table BOOK_TBL_06;

SELECT *
FROM BOOK_TBL_06;

insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (100
                        ,'리눅스'
                        ,'100.jpg'
                        ,'2015-09-02'
                        ,24000
                        ,'나룩스'
                        ,'운영체제, DB기초, 네트워크기초, 개발환격구축'); 
               
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (101
                        ,'자바'
                        ,'101.jpg'
                        ,'2016-01-10'
                        ,20000
                        ,'이자바'
                        ,'프로그래밍 언어');                           
                        
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (102
                        ,'자바웹프로그래밍'
                        ,'102.jpg'
                        ,'2016-10-30'
                        ,25000
                        ,'김프로'
                        ,'개발환경/서버프로그램/배치프로그램');   
                        
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (103
                        ,'오픈소스활용하기'
                        ,'103.jpg'
                        ,'2017-09-01'
                        ,30000
                        ,'박오픈'
                        ,'형상관리, 빌드, 배포'); 
                        
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (104
                        ,'HTML'
                        ,'104.jpg'
                        ,'2018-04-04'
                        ,10000
                        ,'홍길동'
                        ,'HTML/CSS/JAVASCRIPT/JQUERY');   

create table RENT_TBL_06(
 RENT_NO NUMBER NOT NULL 
,BOOK_NO NUMBER NOT NULL
,RENT_PRICE NUMBER NOT NULL 
,RENT_DATE DATE NOT NULL 
,RENT_STATUS CHAR(1) DEFAULT '0' 
);

--drop table RENT_TBL_06;
 
ALTER TABLE RENT_TBL_06 ADD CONSTRAINT rent_pk PRIMARY KEY (RENT_NO);

insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10001, 100, 2400, '2018-07-02', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10002, 101, 2000, '2018-07-04', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10003, 100, 2400, '2018-08-02', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10004, 100, 2400, '2018-08-12', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10005, 102, 2500, '2018-08-03', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date)
values                  (10006, 103, 3000, '2018-08-13');
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10007, 103, 3000, '2018-08-20', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date, rent_status)
values                  (10008, 100, 2400, '2018-09-03', 1);
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date)
values                  (10009, 100, 2400, '2018-09-08');
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date)
values                  (10010, 100, 2400, '2018-09-14');
insert into RENT_TBL_06 (rent_no, book_no, rent_price, rent_date)
values                  (10011, 102, 2500, '2018-09-14');

drop TABLE RENT_TBL_06;


select *
from rent_tbl_06
order by rent_no;

SELECT NVL(MAX(BOOK_NO),105)+1
		 FROM book_tbl_06;

SELECT *
FROM book_tbl_06;

SELECT  b.book_no as "도서번호"
       ,b.book_name as "도서명"
       ,sum(r.rent_price) as "sum"
       ,count(r.book_no) as "count"
from book_tbl_06 b
join rent_tbl_06 r
on b.book_no = r.book_no
GROUP by b.book_no, b.book_name
order by b.book_no;


SELECT   b.book_no 
       			,b.book_name 
       			,sum(r.rent_price) 
       			,count(r.book_no) 
        FROM book_tbl_06 b
        JOIN rent_tbl_06 r
        ON b.book_no = r.book_no
        GROUP by b.book_no, b.book_name;
        
        
SELECT   b.book_no 
       			,b.book_name 
       			,sum(r.rent_price) as sum
       			,count(r.book_no)  as count
        FROM book_tbl_06 b
        JOIN rent_tbl_06 r
        ON b.book_no = r.book_no
        GROUP by b.book_no, b.book_name;        