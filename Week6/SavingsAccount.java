package Week_Six2;

public class SavingsAccount extends BankAccount {
	private double interestRate;  //存储卡利率

	public SavingsAccount() {
		super();
		this.interestRate = 0.0;
	}
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	/*根据账户余额和利率计算每月利息*/
	public void payInterest() {
		double t = super.getBalance()*(interestRate/100);
		super.setBalance(super.getBalance() + t);
		System.out.println("本月您的存款利息为:" + t);
	}
	public String toString() {
		String info;
		info = "存储卡" + super.toString();
		info += "\n存储卡利率=" + this.interestRate;
		return info;
	}
}

