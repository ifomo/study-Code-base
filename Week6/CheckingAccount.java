package Week_Six2;

public class CheckingAccount extends BankAccount {
	private double serviceCharge;  //���ÿ������
	private double maxMoney; //���ÿ���ȣ��ɸı䣡
	private double repayMoney; 
	//��Ҫ��������ſͻ����������

	public CheckingAccount() {
		super();
		this.serviceCharge = 0.0;
		this.maxMoney = 0.0;
		this.repayMoney = 0.0;
	}
	public CheckingAccount(String accountNum, double balance, double serviceCharge) {
		super(accountNum, balance);
		this.serviceCharge = serviceCharge;
		this.maxMoney = balance;
		this.repayMoney = 0.0;
//		this.repayMoney = this.serviceCharge;
	}

	public double getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public double getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(double maxMoney) {
		this.maxMoney = maxMoney;
	}
	public double getRepayMoney() {
		return repayMoney;
	}
	public void setRepayMoney(double repayMoney) {
		this.repayMoney = repayMoney;
	}
	
	public void assessServiceCharge() {
//		System.out.println("�������ķ����Ϊ:" + serviceCharge);
//		this.repayMoney = -1*(this.maxMoney-super.getBalance()+this.serviceCharge);
		System.out.println("��������Ҫ����:" + this.repayMoney);
	}
	
	public String toString() {
		String info;
		info = "���ÿ�" + super.toString();
		info += "\n���ÿ������=" + this.serviceCharge;
		return info;
	}
}

