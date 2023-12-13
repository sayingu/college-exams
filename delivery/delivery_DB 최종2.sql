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

/*��*/

insert into CUSTOMER values("TT","1234","ȫ�浿", "��⵵ ������", "010-9094-6705", "2021-04-24", 0,0);

insert into CUSTOMER values("AI","5678","������", "����Ư����", "010-9832-2334", "2021-05-13",0, 0);

insert into CUSTOMER values("BK","9021","õ����", "������", "010-5752-2130","2021-05-14",0, 0);

insert into CUSTOMER values("RE","8072","������", "�뱸��", "010-8931-6721", "2021-05-06", 0,0);

insert into CUSTOMER values("UW","9032","������", "�λ��", "010-9058-1213", "2021-05-08", 0,0);

insert into CUSTOMER values("KI","7124","��γ�", "��õ��", "010-9071-0361","2021-05-07", 0, 0);



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

insert into  STORE_ADMIN values("MK", "�������н�", "��ö��","1234", "010-1330-1234","����", "2019-05-04" );
insert into  STORE_ADMIN values("UM", "���������","�ڼ���", "4025", "010-8932-1027","����","2017-03-08");
insert into  STORE_ADMIN values("ZH", "¥��","������", "9037", "010-2271-3246","���","2016-09-22");
insert into  STORE_ADMIN values("IJ", "�ѱ��Ǹ�","������", "7201", "010-7952-8541","����","2018-07-26");
insert into  STORE_ADMIN values("KOO", "ġŲ�̾���","�̰���", "6237", "010-9928-7303","���","2021-03-12");
insert into  STORE_ADMIN values("QP", "�Ƶ�����","���Ѻ�", "8246", "010-8067-5431","��û","2020-05-20");








/*DROP TABLE STORE;*/

CREATE TABLE STORE(
SNAME VARCHAR(20),
CLASSIFICATION VARCHAR(20) not null,
OPENTIME TIME,  /*������ */
CLOSETIME TIME, /* ������ */
PRIMARY KEY(SNAME));

insert into STORE values( "�������н�", "Flourfood", "10:30", "21:30");
insert into STORE values( "���������", "Pizza",  "12:00", "12:00");
insert into STORE values( "¥��", "Cfood",  "8:00", "21:30");
insert into STORE values( "�ѱ��Ǹ�", "Kfood", "07:00", "22:00");
insert into STORE values( "ġŲ�̾���", "Kfood", "14:00","2:00");
insert into STORE values( "�Ƶ�����", "Fastfood", "12:00", "22:00");




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

insert into MENU values( "�������н�", "���ζ�����", 6000, "���� ���߰���� ���� ���� ���"
,1,0,0.1);
insert into MENU values( "���������", "�Ұ������", 12000, "�ӽ� ġ� ���",
1,0,0.2);
insert into MENU values( "¥��", "�Ｑ¥��", 7000, "����ҽ��� ���",
1,0,0.03);
insert into MENU values( "�ѱ��� ��", "��ä�����", 15000, "��ö ������ ���",
1,0,0.02);
insert into MENU values( "ġŲ�̾���", "�Ѹ�Ŭ", 22000, "�⸧�� 20ȸ�̻� ������� ����",
1,0,0);
insert into MENU values( "�Ƶ�����", "��ũ�����ǹ���", 9000, "������ �����̾� ġŲ ����"
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

insert into ORDERS values("0001", "TT", "�������н�","���ζ�����" , "13:32", 6000,
"���������� ì���ּ���", "2021-04-24", 1, 800,NULL,0,NULL,NULL, NULL);

insert into ORDERS values("0002", "BK", "���������","�Ұ������","15:41", 12000,
"ġ���� �ּҽ� �� �ּ���", "2021-04-22", 1, 1500, NULL,0,NULL,NULL,"�� ����");


insert into ORDERS values( "0003","AI", "¥��", "�Ｑ¥��","17:18", 7000,
"������ ���� �ּ���", "2021-05-02", 1, 300,NULL,0,NULL,NULL,"�׳� ¥������ ��ȯ");


insert into ORDERS values( "0005","RE", "�ѱ��Ǹ�", "��ä�����","18:01", 15000,
"�ñ�ġ �˷����� �־��", "2021-05-13", 1, 3000,NULL,0,NULL,NULL, "��ä�������� ��ȯ");

insert into ORDERS values( "0004","UW", "ġŲ�̾���", "�Ѹ�Ŭ","21:06", 22000,
"ġŲ�� 2�� �ּ���", "2021-05-17", 1, 1500,NULL,0,NULL,NULL,"�� ����");


insert into ORDERS values( "0006","KI", "�Ƶ�����", "��ũ�����ǹ���","20:23", 9000,
"�ɪy �� �ּ���", "2021-05-11", 1, 3600,NULL,0,NULL,NULL, "����� ����");

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





