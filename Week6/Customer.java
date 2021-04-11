package Week_Six2;

public class Customer {
	private String ssn;  //���֤��
	private String name;  //����
	private CheckingAccount ca = null;
	private SavingsAccount sa = null;
	
	public Customer(String ssn, String name, CheckingAccount ca, SavingsAccount sa) {
		this.ssn = ssn;
		this.name = name;
		this.ca = ca;
		this.sa = sa;
	}

	public CheckingAccount getCa() {
		return ca;
	}
	public void setCa(CheckingAccount ca) {
		this.ca = ca;
	}
	public SavingsAccount getSa() {
		return sa;
	}
	public void setSa(SavingsAccount sa) {
		this.sa = sa;
	}

	public String toString() {
		String msg;
		msg = "���֤��=" + this.ssn +"\t";
		msg += "����=" + this.name;
		if(ca!=null)
			msg += "\n" + ca.toString();
		if(sa!=null)
			msg += "\n" + sa.toString();
		return msg;
	}
}
