package delivery;




public class Customer extends Member {

	String RANK; //���  �Ϲ�,VIP
	int OCNT; //�ֹ�Ƚ��
	int TP; //�ֹ��ѱݾ�
	float CGPA; //������
	int RCNT; //�Ѹ���Ǽ�
	
	
	
	public Customer() {
	
	}

	public Customer(String ID, String PW, String NAME, String ADD,String CP,String RANK,int OCNT,int TP,float CGPA,int RCNT) {
		super(ID,PW,NAME,ADD,CP);
		this.RANK =RANK;
		this.OCNT =OCNT;
		this.TP =TP;
		this.CGPA =CGPA;
		this.RCNT =RCNT;
	}
	
	public Customer(String ID, String PW, String NAME, String ADD,String CP,java.sql.Date DATEJOIN,String RANK,int OCNT,int TP,float CGPA,int RCNT) {
		super(ID,PW,NAME,ADD,CP,DATEJOIN);
		this.RANK =RANK;
		this.OCNT =OCNT;
		this.TP =TP;
		this.CGPA =CGPA;
		this.RCNT =RCNT;
	}
	
	
	//get set
	public String getRANK() {
		return RANK;
	}

	public void setRANK(String rANK) {
		RANK = rANK;
	}

	public int getOCNT() {
		return OCNT;
	}

	public void setOCNT(int oCNT) {
		OCNT = oCNT;
	}

	public int getTP() {
		return TP;
	}

	public void setTP(int tP) {
		TP = tP;
	}

	public float getCGPA() {
		return CGPA;
	}

	public void setCGPA(float cGPA) {
		CGPA = cGPA;
	}

	public int getRCNT() {
		return RCNT;
	}

	public void setRCNT(int rCNT) {
		RCNT = rCNT;
	}
	
	
	
	
}
