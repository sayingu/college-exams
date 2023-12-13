package delivery;

import java.util.Date;

public class Member {
	private String ID; // ���̵�
	private String PW; // ��й�ȣ
	private String NAME; // �̸�
	private String ADD; // �ּ�
	private String CP; // ��ȭ��ȣ
	private java.sql.Date DATEJOIN; // ���Գ�¥

	public Member() {

	}

	public Member(String ID, String PW, String NAME, String ADD, String CP) {
		this.ID = ID;
		this.PW = PW;
		this.NAME = NAME;
		this.ADD = ADD;
		this.CP = CP;

		setDATEJOiN(); // �������� �������������� �����Ͽ� ����
	}

	public Member(String ID, String PW, String NAME, String ADD, String CP, java.sql.Date DATEJOIN) {
		this.ID = ID;
		this.PW = PW;
		this.NAME = NAME;
		this.ADD = ADD;
		this.CP = CP;
		this.DATEJOIN = DATEJOIN;
	}

	private void setDATEJOiN() {
		this.DATEJOIN = new java.sql.Date((new Date()).getTime()); // �����ϻ���

	}

	public static String encriptPassword(String PW) {
		if (PW == null || PW.equals(""))
			return "1Ew$H6KhfKHJHG";

		return "" + PW.hashCode(); // Java�� hashCode() �޼ҵ带 �̿��� ���� ������ ��ȣȭ
	}

	public void encriptPassword() {
		PW = encriptPassword(PW);
	}

	public void output() {
		// ������ ��� ���� ���
		System.out.print("���̵�: " + ID + ",  ");
		System.out.print("�н�����: " + PW + ", ");
		System.out.print("�̸�: " + NAME + ",  ");
		System.out.print("�ּ�: " + ADD + ",  ");
		System.out.print("����ó: " + CP + ",  ");
		System.out.print("������: " + DATEJOIN + ", ");

		System.out.println();

	}

	// get set

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getADD() {
		return ADD;
	}

	public void setADD(String aDD) {
		ADD = aDD;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public java.sql.Date getDATE() {
		return DATEJOIN;
	}

	public void setDATE(java.sql.Date DATEJOiN) {
		DATEJOIN = DATEJOiN;
	}

}