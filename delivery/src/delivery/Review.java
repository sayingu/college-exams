package delivery;

import java.sql.Time;
import java.util.*;

/*
 * 		Cancel: 취소 객체 선언  클래스
 *   o Cancel 클래스는 delivery 데이터베이스에서 cancel 테이블과 매치되는 클래스로
 *     cancel 테이블의 한 투플과 Cancel 클래스의 한 객체가 상호 대응
 */

public class Review extends Orders{//가게리뷰내용, 가게평점, 메뉴리뷰내용, 메뉴평점, 작성날짜, 작성시간, 변경이유
	String SREVIEW;//가게리뷰내용
	float SGPA;//가게평점
	String MREVIEW;	//메뉴리뷰내용
	float MGPA;//메뉴평점
	java.sql.Date WDATE;//작성날짜
	Time WTIME;//작성시간
	String CHAREASON;//변경이유
	
	public Review() {
	}

    // 계좌 객체 생성자 - 계좌 유형이 주어지면 유형별 다음 계좌번호를 생성하여 계좌 객체를 생성 
	/*public Cancel(String accType, String owner, Date dateOpend, int balance) {
		this.accType = accType;
		this.accno = DB.getNextSerial(accType);
		this.owner = owner; 
		this.dateOpend = new java.sql.Date(dateOpend.getTime()); // java.util.Date 객체를 java.sql.Date 객체로 변환시킴 
		this.balance = balance;	
	}*/
	public Review(String ONUM,	String CID,	String SNAME,	String MNAME,
	String OTIME,	int TP,	String REQUEST,	java.sql.Date ODATE,
	int OCNT,	int DAMOUT,	String SREVIEW,	float SGPA,	String MREVIEW,
	float MGPA,	java.sql.Date WDATE,	Time WTIME,	String CHAREASON) 
	{	super(ONUM,	CID,	SNAME,MNAME,OTIME, TP, REQUEST,ODATE, OCNT, DAMOUT);
	this.SREVIEW=SREVIEW;this.SGPA=SGPA;this.MREVIEW=MREVIEW;this.MGPA=MGPA;
	this.WDATE=new java.sql.Date(WDATE.getTime()); this.WTIME=new java.sql.Time(WTIME.getTime()); this.CHAREASON=CHAREASON;
	}	
	
	
public String getSREVIEW() {
		return SREVIEW;
	}

	public float getSGPA() {
		return SGPA;
	}

	public String getMREVIEW() {
		return MREVIEW;
	}

	public float getMGPA() {
		return MGPA;
	}

	public java.sql.Date getWDATE() {
		return WDATE;
	}

	public Time getWTIME() {
		return WTIME;
	}

	public String getCHAREASON() {
		return CHAREASON;
	}

	/*	
	public int getAccno() {
		return accno;
	}
	public int getBalance() {
		return balance;
	}
	public void addBalance(int amount) {
		balance += amount;
	}

	// 계좌정보 출력
	public void output() {
		System.out.print("  * 계좌유형: " + accType +",  ");
		System.out.print("계좌번호: " + accno +",  ");
		System.out.print("소유자: " + owner+",  ");
		System.out.print("잔액: " + balance+",   ");
		System.out.print("개설일: " + dateOpend +"\n");
	}	*/
	public void output() {}

	
}