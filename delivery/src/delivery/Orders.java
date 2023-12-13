package delivery;

import java.util.*;

/*
 * 		Cancel: ��� ��ü ����  Ŭ����
 *   o Cancel Ŭ������ delivery �����ͺ��̽����� cancel ���̺�� ��ġ�Ǵ� Ŭ������
 *     cancel ���̺��� �� ���ð� Cancel Ŭ������ �� ��ü�� ��ȣ ����
 */

public class Orders {
	String ONUM;	//�ֹ� ��ȣ
	String CID;	//�����̵�
	String SNAME;	//�����̸�
	String MNAME;	//�޴��̸�
	String OTIME;	//�ֹ��ð�
	int TP;	//�Ѱ���
	String REQUEST;	//��û����
	java.sql.Date ODATE;	//�ֹ���¥
	int OCNT;	//�ֹ�����
	int DAMOUT;	//���αݾ�
	// ��¥ - Java���� Date Ŭ������ 2��(java.util.Date, java.sql.Date) ������, 
    //          JDBC���� ���Ǵ� Date Ŭ������ java.sql.Date��
	
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