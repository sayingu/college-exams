package delivery;
import java.util.Date;


public class Menu {
	String SNAME; //�����̸�
	String MNAME; //�޴��̸�
	int PRICE; //�޴�����
	String INTRO; //�޴��Ұ�
	int OCNT; //�ֹ�Ƚ��
	float SALE; //������
	
	
	
	public Menu() {
		
	}
	
	public Menu(String SNAME, String MNAME,int PRICE,String INTRO,int OCNT,float SALE) {
		
		this.SNAME = SNAME;
		this.MNAME = MNAME;
		this.PRICE = PRICE;
		this.INTRO = INTRO;
		this.OCNT = OCNT;
		this.SALE = SALE;
		
		
		
	}
	
	public void output() {
		//�޴� ���� ���
		System.out.print("�����̸�: " + SNAME +",  ");
		System.out.print("�޴��̸�: " + MNAME +", ");
		System.out.print("����: " + PRICE+",  ");
		System.out.print("�Ұ�: " + INTRO+",  ");
		System.out.print("�ֹ�Ƚ��: " + OCNT+",  ");
		System.out.print("������: " + SALE+",  ");

		
		System.out.println();

	}
	//get set

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public String getMNAME() {
		return MNAME;
	}

	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getINTRO() {
		return INTRO;
	}

	public void setINTRO(String iNTRO) {
		INTRO = iNTRO;
	}

	public int getOCNT() {
		return OCNT;
	}

	public void setOCNT(int oCNT) {
		OCNT = oCNT;
	}

	public float getSALE() {
		return SALE;
	}

	public void setSALE(float sALE) {
		SALE = sALE;
	}
	
	

	
	
	
	
}
