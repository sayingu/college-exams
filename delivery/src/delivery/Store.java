package delivery;




public class Store {
	String SNAME; //�����̸�
	String CLASSIFICATION; //�з�
	int RCNT; //����Ǽ�
	float SGPA;//��������
	String OPENTIME;//���½ð�
	String CLOSETIME;//����ð�
	
	
	
	public Store() {
		
	}
	
	public Store(String SNAME, String CLASSIFICATION,int RCNT,float SGPA,String OPENTIME,String CLOSETIME) {
		
		this.SNAME = SNAME;
		this.CLASSIFICATION = CLASSIFICATION;
		this.SGPA = SGPA;
		this.RCNT = RCNT;
		this.OPENTIME = OPENTIME;
		this.CLOSETIME = CLOSETIME;
		
		
	}
	
	//get set
	
	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public String getCLASSIFICATION() {
		return CLASSIFICATION;
	}

	public void setCLASSIFICATION(String cLASSIFICATION) {
		CLASSIFICATION = cLASSIFICATION;
	}

	public float getSGPA() {
		return SGPA;
	}

	public void setMGPA(float sGPA) {
		SGPA = sGPA;
	}

	public int getRCNT() {
		return RCNT;
	}

	public void setRCNT(int rCNT) {
		RCNT = rCNT;
	}
	
	public String getOPENTIME() {
		return OPENTIME;
	}
	
	public String setOPENTIME(String oPENTIME) {
		return OPENTIME = oPENTIME;
	}
	
	public String getCLOSETIME() {
		return CLOSETIME;
	}
	
	public String setCLOSETIME(String cLOSETIME) {
		return CLOSETIME = cLOSETIME;
	}
	
	
}
