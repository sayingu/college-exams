package delivery;

import java.sql.Time;
import java.util.*;

/*
 * 		Cancel: ��� ��ü ����  Ŭ����
 *   o Cancel Ŭ������ delivery �����ͺ��̽����� cancel ���̺�� ��ġ�Ǵ� Ŭ������
 *     cancel ���̺��� �� ���ð� Cancel Ŭ������ �� ��ü�� ��ȣ ����
 */

public class Review extends Orders{//���Ը��䳻��, ��������, �޴����䳻��, �޴�����, �ۼ���¥, �ۼ��ð�, ��������
	String SREVIEW;//���Ը��䳻��
	float SGPA;//��������
	String MREVIEW;	//�޴����䳻��
	float MGPA;//�޴�����
	java.sql.Date WDATE;//�ۼ���¥
	Time WTIME;//�ۼ��ð�
	String CHAREASON;//��������
	
	public Review() {
	}

    // ���� ��ü ������ - ���� ������ �־����� ������ ���� ���¹�ȣ�� �����Ͽ� ���� ��ü�� ���� 
	/*public Cancel(String accType, String owner, Date dateOpend, int balance) {
		this.accType = accType;
		this.accno = DB.getNextSerial(accType);
		this.owner = owner; 
		this.dateOpend = new java.sql.Date(dateOpend.getTime()); // java.util.Date ��ü�� java.sql.Date ��ü�� ��ȯ��Ŵ 
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

	// �������� ���
	public void output() {
		System.out.print("  * ��������: " + accType +",  ");
		System.out.print("���¹�ȣ: " + accno +",  ");
		System.out.print("������: " + owner+",  ");
		System.out.print("�ܾ�: " + balance+",   ");
		System.out.print("������: " + dateOpend +"\n");
	}	*/
	public void output() {}

	
}