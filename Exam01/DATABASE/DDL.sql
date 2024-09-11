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
                        ,'������'
                        ,'100.jpg'
                        ,'2015-09-02'
                        ,24000
                        ,'���轺'
                        ,'�ü��, DB����, ��Ʈ��ũ����, ����ȯ�ݱ���'); 
               
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (101
                        ,'�ڹ�'
                        ,'101.jpg'
                        ,'2016-01-10'
                        ,20000
                        ,'���ڹ�'
                        ,'���α׷��� ���');                           
                        
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (102
                        ,'�ڹ������α׷���'
                        ,'102.jpg'
                        ,'2016-10-30'
                        ,25000
                        ,'������'
                        ,'����ȯ��/�������α׷�/��ġ���α׷�');   
                        
insert into book_tbl_06 (BOOK_NO
                        ,BOOK_NAME
                        ,BOOK_COVERIMG
                        ,BOOK_DATE
                        ,BOOK_PRICE
                        ,BOOK_PUBLISHER
                        ,BOOK_INFO)
              VALUES    (103
                        ,'���¼ҽ�Ȱ���ϱ�'
                        ,'103.jpg'
                        ,'2017-09-01'
                        ,30000
                        ,'�ڿ���'
                        ,'�������, ����, ����'); 
                        
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
                        ,'ȫ�浿'
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

SELECT  b.book_no as "������ȣ"
       ,b.book_name as "������"
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