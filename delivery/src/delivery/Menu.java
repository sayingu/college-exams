package delivery;
import java.util.Date;


public class Menu {
	String SNAME; //가게이름
	String MNAME; //메뉴이름
	int PRICE; //메뉴가격
	String INTRO; //메뉴소개
	int OCNT; //주문횟수
	float SALE; //할인율
	
	
	
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
		//메뉴 정보 출력
		System.out.print("가게이름: " + SNAME +",  ");
		System.out.print("메뉴이름: " + MNAME +", ");
		System.out.print("가격: " + PRICE+",  ");
		System.out.print("소개: " + INTRO+",  ");
		System.out.print("주문횟수: " + OCNT+",  ");
		System.out.print("할인율: " + SALE+",  ");

		
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
