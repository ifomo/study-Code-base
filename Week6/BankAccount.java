package Week_Six2;

public class BankAccount {
	private String accountNum;  //���п���
	private double balance;  //�˻����
	
	public BankAccount() {
		this.accountNum = "��δ������";
		this.balance = 0.0;  //Ĭ�ϳ�ʼֵ
	}
	public BankAccount(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	//����һ�㲻�������޸ģ�
	public String getAccountNum() {
		return accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		String info;
		info = "����=" + this.accountNum + "\n";
		info += "�˻����=" + this.balance + "\n";
		return info;
	}
}

