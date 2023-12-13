package delivery;

import java.util.Date;

public class Member {
	private String ID; // 아이디
	private String PW; // 비밀번호
	private String NAME; // 이름
	private String ADD; // 주소
	private String CP; // 전화번호
	private java.sql.Date DATEJOIN; // 가입날짜

	public Member() {

	}

	public Member(String ID, String PW, String NAME, String ADD, String CP) {
		this.ID = ID;
		this.PW = PW;
		this.NAME = NAME;
		this.ADD = ADD;
		this.CP = CP;

		setDATEJOiN(); // 가입일이 정해지지않으면 생성하여 저장
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
		this.DATEJOIN = new java.sql.Date((new Date()).getTime()); // 가입일생성

	}

	public static String encriptPassword(String PW) {
		if (PW == null || PW.equals(""))
			return "1Ew$H6KhfKHJHG";

		return "" + PW.hashCode(); // Java의 hashCode() 메소드를 이용한 아주 간단한 암호화
	}

	public void encriptPassword() {
		PW = encriptPassword(PW);
	}

	public void output() {
		// 가입자 등록 정보 출력
		System.out.print("아이디: " + ID + ",  ");
		System.out.print("패스워드: " + PW + ", ");
		System.out.print("이름: " + NAME + ",  ");
		System.out.print("주소: " + ADD + ",  ");
		System.out.print("연락처: " + CP + ",  ");
		System.out.print("가입일: " + DATEJOIN + ", ");

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