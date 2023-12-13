package delivery;

import java.sql.Time;
import java.util.Date;


/*
 * 		Cancel: ��� ��ü ����  Ŭ����
 *   o Cancel Ŭ������ delivery �����ͺ��̽����� cancel ���̺�� ��ġ�Ǵ� Ŭ������
 *     cancel ���̺��� �� ���ð� Cancel Ŭ������ �� ��ü�� ��ȣ ����
 */

public class Cancel extends Orders{

	java.sql.Date CDATE;	//��ҳ�¥
	java.sql.Time CTIME;	//��ҽð�
	String CHREASON;	//�������
	
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
		//��� ���� ���
		
		System.out.print("�ֹ���ȣ: " + OTIME +",  ");
		System.out.print("�����̵�: " + CID +", ");
		System.out.print("�����̸�: " + SNAME +", ");
		System.out.print("�޴��̸�: " + MNAME +", ");
		
		System.out.print("��ҳ�¥: " + CDATE+",  ");
		System.out.print("��ҽð�: " + CTIME+",  ");
		System.out.print("�������: " + CHREASON+",  ");
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