package delivery;

import java.sql.Time;
import java.util.Date;


/*
 * 		Cancel: 취소 객체 선언  클래스
 *   o Cancel 클래스는 delivery 데이터베이스에서 cancel 테이블과 매치되는 클래스로
 *     cancel 테이블의 한 투플과 Cancel 클래스의 한 객체가 상호 대응
 */

public class Cancel extends Orders{

	java.sql.Date CDATE;	//취소날짜
	java.sql.Time CTIME;	//취소시간
	String CHREASON;	//취소이유
	
	public Cancel() {
	}

   
	public Cancel(String ONUM,	String CID,	String SNAME,	String MNAME,
	String OTIME,	int TP,	String REQUEST,	java.sql.Date ODATE,
	int OCNT,	int DAMOUT,	java.sql.Date CDATE,	java.sql.Time CTIME,	String CHREASON) 
	{	
		super(ONUM,	CID,	SNAME,MNAME,OTIME, TP, REQUEST,ODATE, OCNT, DAMOUT);
		this.CDATE= new java.sql.Date(CDATE.getTime());
		this.CTIME=CTIME;	
		this.CHREASON=CHREASON;

	}	
	

	public void output() {
		//취소 정보 출력
		
		System.out.print("주문번호: " + OTIME +",  ");
		System.out.print("고객아이디: " + CID +", ");
		System.out.print("가게이름: " + SNAME +", ");
		System.out.print("메뉴이름: " + MNAME +", ");
		
		System.out.print("취소날짜: " + CDATE+",  ");
		System.out.print("취소시간: " + CTIME+",  ");
		System.out.print("취소이유: " + CHREASON+",  ");
	}


	
	
	//get set
	public java.sql.Date getCDATE() {
		return CDATE;
	}


	public void setCDATE(java.sql.Date cDATE) {
		CDATE = cDATE;
	}


	public java.sql.Time getCTIME() {
		return CTIME;
	}


	public void setCTIME(java.sql.Time cTIME) {
		CTIME = cTIME;
	}


	public String getCHREASON() {
		return CHREASON;
	}


	public void setCHREASON(String cHREASON) {
		CHREASON = cHREASON;
	}

	
}