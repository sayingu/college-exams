CREATE DATABASE delivery default CHARACTER SET UTF8;

USE delivery;

/*DROP TABLE CUSTOMER;*/

CREATE TABLE CUSTOMER(
CID VARCHAR(20),
PW VARCHAR(20)  not null,
CNAME VARCHAR(20) not null,
ADDRESS VARCHAR(20) not null,
CP VARCHAR(20),
SDATE DATE,
OCNT INT,
RCNT INT,
PRIMARY KEY(CID));

/*고객*/

insert into CUSTOMER values("TT","1234","홍길동", "경기도 수원시", "010-9094-6705", "2021-04-24", 0,0);

insert into CUSTOMER values("AI","5678","서지연", "서울특별시", "010-9832-2334", "2021-05-13",0, 0);

insert into CUSTOMER values("BK","9021","천서진", "대전시", "010-5752-2130","2021-05-14",0, 0);

insert into CUSTOMER values("RE","8072","엄기준", "대구시", "010-8931-6721", "2021-05-06", 0,0);

insert into CUSTOMER values("UW","9032","박은석", "부산시", "010-9058-1213", "2021-05-08", 0,0);

insert into CUSTOMER values("KI","7124","배로나", "인천시", "010-9071-0361","2021-05-07", 0, 0);



/*DROP TABLE STORE_ADMIN;*/

CREATE TABLE STORE_ADMIN(
SID VARCHAR(20),
SNAME VARCHAR(20) not null,
SADNAME VARCHAR(20) not null,
PW VARCHAR(20) not null,
CP VARCHAR(20),
ADDRESS VARCHAR(20),
SDATE DATE,
PRIMARY KEY (SID));

insert into  STORE_ADMIN values("MK", "맛나리분식", "김철수","1234", "010-1330-1234","서울", "2019-05-04" );
insert into  STORE_ADMIN values("UM", "배달의피자","박서현", "4025", "010-8932-1027","서울","2017-03-08");
insert into  STORE_ADMIN values("ZH", "짜왕","김진형", "9037", "010-2271-3246","경기","2016-09-22");
insert into  STORE_ADMIN values("IJ", "한국의맛","이현석", "7201", "010-7952-8541","서울","2018-07-26");
insert into  STORE_ADMIN values("KOO", "치킨이어디닭","이가빈", "6237", "010-9928-7303","경기","2021-03-12");
insert into  STORE_ADMIN values("QP", "맥도리아","조한빈", "8246", "010-8067-5431","충청","2020-05-20");








/*DROP TABLE STORE;*/

CREATE TABLE STORE(
SNAME VARCHAR(20),
CLASSIFICATION VARCHAR(20) not null,
OPENTIME TIME,  /*변경점 */
CLOSETIME TIME, /* 변경점 */
PRIMARY KEY(SNAME));

insert into STORE values( "맛나리분식", "Flourfood", "10:30", "21:30");
insert into STORE values( "배달의피자", "Pizza",  "12:00", "12:00");
insert into STORE values( "짜왕", "Cfood",  "8:00", "21:30");
insert into STORE values( "한국의맛", "Kfood", "07:00", "22:00");
insert into STORE values( "치킨이어디닭", "Kfood", "14:00","2:00");
insert into STORE values( "맥도리아", "Fastfood", "12:00", "22:00");




/*DROP TABLE MENU;*/

CREATE TABLE MENU(
SNAME VARCHAR(20),
MNAME VARCHAR(20),
PRICE INT not null,
INTRO VARCHAR(20),
OCNT INT,
RCNT INT,
SALE float,
PRIMARY KEY(SNAME ,MNAME)
);

insert into MENU values( "맛나리분식", "코인떡볶이", 6000, "국산 고추가루와 국산 떡을 사용"
,1,0,0.1);
insert into MENU values( "배달의피자", "불고기피자", 12000, "임실 치즈를 사용",
1,0,0.2);
insert into MENU values( "짜왕", "삼선짜장", 7000, "비법소스를 사용",
1,0,0.03);
insert into MENU values( "한국의 맛", "산채비빔밥", 15000, "제철 나물을 사용",
1,0,0.02);
insert into MENU values( "치킨이어디닭", "뿌링클", 22000, "기름을 20회이상 사용하지 않음",
1,0,0);
insert into MENU values( "맥도리아", "핫크리스피버거", 9000, "매콤한 프리미엄 치킨 버거"
,1,0,0);





/*DROP TABLE ORDERS;*/

CREATE TABLE ORDERS(
ONUM VARCHAR(20),
CID VARCHAR(20),
SNAME VARCHAR(20),
MNAME  VARCHAR(20),
OTIME TIME,
TP  INT ,
REQUEST VARCHAR(100),
ODATE DATE,
OCNT INT,
DAMOUT INT,
MREVIEW VARCHAR(100),
MGPA INT,
WDATE DATE,
WTIME TIME,
CHAREASON VARCHAR(20),
PRIMARY KEY(CID,SNAME,ONUM,MNAME)
);

insert into ORDERS values("0001", "TT", "맛나리분식","코인떡볶이" , "13:32", 6000,
"나무젓가락 챙겨주세요", "2021-04-24", 1, 800,NULL,0,NULL,NULL, NULL);

insert into ORDERS values("0002", "BK", "배달의피자","불고기피자","15:41", 12000,
"치즈가루랑 핫소스 꼭 주세요", "2021-04-22", 1, 1500, NULL,0,NULL,NULL,"고객 변심");


insert into ORDERS values( "0003","AI", "짜왕", "삼선짜장","17:18", 7000,
"군만두 서비스 주세요", "2021-05-02", 1, 300,NULL,0,NULL,NULL,"그냥 짜장으로 교환");


insert into ORDERS values( "0005","RE", "한국의맛", "산채비빔밥","18:01", 15000,
"시금치 알러지가 있어요", "2021-05-13", 1, 3000,NULL,0,NULL,NULL, "산채정식으로 교환");

insert into ORDERS values( "0004","UW", "치킨이어디닭", "뿌링클","21:06", 22000,
"치킨무 2개 주세요", "2021-05-17", 1, 1500,NULL,0,NULL,NULL,"고객 변심");


insert into ORDERS values( "0006","KI", "맥도리아", "핫크리스피버거","20:23", 9000,
"케챱 더 주세요", "2021-05-11", 1, 3600,NULL,0,NULL,NULL, "배달지 오류");

/*DROP TABLE CANCEL;*/

CREATE TABLE CANCEL(
ONUM VARCHAR(20),
CID VARCHAR(20),
SNAME VARCHAR(20),
MNAME  VARCHAR(20),
OTIME TIME,
TP  INT ,
REQUEST VARCHAR(100),
ODATE DATE,
OCNT INT,
DAMOUT INT,
CDATE DATE,
CTIME TIME,
CHREASON VARCHAR(20),
PRIMARY KEY(CID,SNAME,ONUM,MNAME));





