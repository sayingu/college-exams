package delivery;

import java.util.*;

/*
 * 		Cancel: 취소 객체 선언  클래스
 *   o Cancel 클래스는 delivery 데이터베이스에서 cancel 테이블과 매치되는 클래스로
 *     cancel 테이블의 한 투플과 Cancel 클래스의 한 객체가 상호 대응
 */

public class Orders {
	String ONUM;	//주문 번호
	String CID;	//고객아이디
	String SNAME;	//가게이름
	String MNAME;	//메뉴이름
	String OTIME;	//주문시간
	int TP;	//총가격
	String REQUEST;	//요청사항
	java.sql.Date ODATE;	//주문날짜
	int OCNT;	//주문수량
	int DAMOUT;	//할인금액
	// 날짜 - Java에는 Date 클래스가 2개(java.util.Date, java.sql.Date) 있으며, 
    //          JDBC에서 사용되는 Date 클래스는 java.sql.Date임
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

  
	public Orders(String ONUM,	String CID,	String SNAME,	String MNAME,
	String OTIME,	int TP,	String REQUEST,	java.sql.Date ODATE, int OCNT,	int DAMOUT) {
		this.ONUM=ONUM;this.CID=CID;this.SNAME=SNAME;this.MNAME=MNAME;
		this.OTIME=OTIME;this.TP=TP;this.REQUEST=REQUEST;this.ODATE=new java.sql.Date(ODATE.getTime());
		this.OCNT=OCNT; this.DAMOUT=DAMOUT;
	}
		
	
	public String getONUM() {
		return ONUM;
	}

	public String getCID() {
		return CID;
	}

	public String getSNAME() {
		return SNAME;
	}

	public String getMNAME() {
		return MNAME;
	}

	public String getOTIME() {
		return OTIME;
	}

	public int getTP() {
		return TP;
	}

	public String getREQUEST() {
		return REQUEST;
	}

	public java.sql.Date getODATE() {
		return ODATE;
	}

	public int getOCNT() {
		return OCNT;
	}

	public int getDAMOUT() {
		return DAMOUT;
	}


	public void output() {}

	
}