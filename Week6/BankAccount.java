package Week_Six2;

public class BankAccount {
	private String accountNum;  //银行卡号
	private double balance;  //账户余额
	
	public BankAccount() {
		this.accountNum = "还未开户！";
		this.balance = 0.0;  //默认初始值
	}
	public BankAccount(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	//卡号一般不会轻易修改！
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
		info = "卡号=" + this.accountNum + "\n";
		info += "账户余额=" + this.balance + "\n";
		return info;
	}
}

