package Week_Six2;

public class CheckingAccount extends BankAccount {
	private double serviceCharge;  //信用卡服务费
	private double maxMoney; //信用卡额度，可改变！
	private double repayMoney; 
	//需要还款金额，随着客户还款而减少

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
//		System.out.println("本月您的服务费为:" + serviceCharge);
//		this.repayMoney = -1*(this.maxMoney-super.getBalance()+this.serviceCharge);
		System.out.println("本月您需要还款:" + this.repayMoney);
	}
	
	public String toString() {
		String info;
		info = "信用卡" + super.toString();
		info += "\n信用卡服务费=" + this.serviceCharge;
		return info;
	}
}

