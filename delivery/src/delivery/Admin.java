package delivery;



public class Admin extends Member {

	String SNAME; //가게 이름
	
	
	
	public Admin() {
	
	}

	public Admin(String ID, String PW, String NAME, String ADD,String CP,String SNAME) {
		super(ID,PW,NAME,ADD,CP);
		this.SNAME =SNAME;
	}
	
	public Admin(String ID, String PW, String NAME, String ADD,String CP,java.sql.Date DATEJOIN,String SNAME) {
		super(ID,PW,NAME,ADD,CP,DATEJOIN);
		this.SNAME =SNAME;
	}
	
	
	//get set
	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String SNAME) {
		SNAME = SNAME;
	}

	public void updateMenuPrice(int price) {
		
	}
	
	
}
