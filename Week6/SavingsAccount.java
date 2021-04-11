package Week_Six2;

public class SavingsAccount extends BankAccount {
	private double interestRate;  //�洢������

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
	
	/*�����˻��������ʼ���ÿ����Ϣ*/
	public void payInterest() {
		double t = super.getBalance()*(interestRate/100);
		super.setBalance(super.getBalance() + t);
		System.out.println("�������Ĵ����ϢΪ:" + t);
	}
	public String toString() {
		String info;
		info = "�洢��" + super.toString();
		info += "\n�洢������=" + this.interestRate;
		return info;
	}
}

