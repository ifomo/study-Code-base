package Week_Six2;

import java.util.Scanner;

public class Part7_2 {
	public static Scanner cin = new Scanner(System.in);
	public static Customer newCus = null;
	public static CheckingAccount userCa = null; //new CheckingAccount(); 
	public static SavingsAccount userSa = null; //new SavingsAccount();
	
	public static void main(String[] a) {
		int choice = mainMeun();
		while(choice!=8) {
			switch(choice){
			case 1: createNewcustomer(); break;
			case 2:	saveMoney(); break;
			case 3: withDrawmoney(); break;
			case 4: comsume(); break;
			case 5: repay(); break;
			case 6: settle(); break;
			case 7: queryMoney(); break;
			default: System.out.println("输入无效，重新选择！");
			}
			choice = mainMeun();
		}
		System.out.println("============欢迎下次使用！============");
		return;
		/*CheckingAccount userCa = new CheckingAccount(); //null;  //new CheckingAccount("12345", 5000, 12.3);
		userCa = new CheckingAccount("12345", 5000, 12.3);  //可以再次初始化！
		System.out.println(userCa.toString());*/  //如果userCa==null，这里调用方法会报错！
	}
	
	/*主菜单*/
	public static int mainMeun() {
		System.out.println("==========欢迎使用银行系统！==========");
		System.out.println("1.开户");
		System.out.println("2.存款");
		System.out.println("3.取款");
		System.out.println("4.消费");
		System.out.println("5.还款");
		System.out.println("6.银行结算");
		System.out.println("7.查询余额");
		System.out.println("8.退出");
		
		System.out.println("请输入您的选择(1-8):");
		int choice = cin.nextInt();
		return choice;
	}
	
	/*开户菜单*/
	public static int subMeun() {
		System.out.println("==========请选择开卡类型！==========");
		System.out.println("1.信用卡");
		System.out.println("2.存款卡");
		System.out.println("3.返回主菜单");
		/*必须两张卡都要办吗？但是我们的Customer类的构造方法包含两张卡类；
		 *就实际来说可以不一定都办，所以我们可以使用无参数构造方法来初始不开户的卡。*/
		
		System.out.println("请输入您的选择(1-3):");
		int choice = cin.nextInt();
		return choice;
	}
	
	/*1.开户*/
	public static void createNewcustomer() {
		int choose = subMeun();
//		CheckingAccount userCa = null; //new CheckingAccount();
//		SavingsAccount userSa = null; //new SavingsAccount();
		
		String ssn="无", name="无";
		/*System.out.print("请输入身份证号:");
		String ssn = cin.next();
		System.out.print("请输入姓名:");
		String name = cin.next();*/
		
		while(choose!=3) {
			if(choose==1) {
				if(userCa!=null) {
					System.out.println("已开办信用卡！回到选择页面...");
				}
				else {
					System.out.print("请输入身份证号:");
					ssn = cin.next();
					System.out.print("请输入姓名:");
					name = cin.next();
					System.out.print("请输入信用卡卡号:");
					String accountNum = cin.next();
					System.out.print("请输入服务费:");
					double serviceCharge = cin.nextDouble();
					userCa = new CheckingAccount(accountNum, 10000, serviceCharge);//余额初始为10000
				}
			}
			else if(choose==2) {
				if(userSa!=null) {
					System.out.println("已开办存储卡！回到选择页面...");
				}
				else {
					System.out.print("请输入身份证号:");
					ssn = cin.next();
					System.out.print("请输入姓名:");
					name = cin.next();
					System.out.print("请输入存储卡卡号:");
					String accountNum = cin.next();
					System.out.print("请输入利率:");
					double interestRate = cin.nextDouble();
					userSa = new SavingsAccount(accountNum, 0.0, interestRate);
				}
			}
			else {
				System.out.println("输入选择错误！请重新输入。");
			}
			choose = subMeun();
		}
		newCus = new Customer(ssn, name, userCa, userSa);
	}
	
	/*2.存款*/
	public static void saveMoney() {
//		System.out.println("请输入存储卡卡号:");  
//目前还只是简单的单用户应用，像客户与工作人员的不同权限控制、用户验证机制...都未开始构建！
		if(userSa==null) {
			System.out.println("抱歉，您尚未开办存储卡！回到首页面...");
			return;
		}
		System.out.println("请输入存款金额:");
		double money = cin.nextDouble();
		double t = newCus.getSa().getBalance();
		newCus.getSa().setBalance(t+money);
		System.out.println("存款成功！");
	}
	
	/*3.取款*/
	public static void withDrawmoney() {
		if(userSa==null) {
			System.out.println("抱歉，您尚未开办存储卡！回到首页面...");
			return;
		}
		System.out.println("请输入取款金额:");
		double money = cin.nextDouble();
		double t = newCus.getSa().getBalance();
		if(money > t) {
			System.out.println("抱歉，卡内余额不足！回到主页面...");
		}
		else {
			newCus.getSa().setBalance(t-money);
			System.out.println("取款成功！");
		}
	}
	
	/*4.消费--信用卡*/
	public static void comsume() {
		if(userCa==null) {
			System.out.println("抱歉，您尚未开办信用卡！回到首页面...");
			return;
		}
		System.out.println("请输入消费金额:");
		double money = cin.nextDouble();
		double t = newCus.getCa().getBalance();
		if(money > t) {
			System.out.println("抱歉，卡内余额不足！回到主页面...");
		}
		else {
			newCus.getCa().setBalance(t-money);
			t=newCus.getCa().getRepayMoney();
			newCus.getCa().setRepayMoney(t+money+newCus.getCa().getServiceCharge());
			//消费一次，服务费增加一次
			System.out.println("消费成功！");
		}
	}
	
	/*5.还款--信用卡*/
	public static void repay() {
		if(userCa==null) {
			System.out.println("抱歉，您尚未开办信用卡！回到首页面...");
			return;
		}
		System.out.println("请输入还款金额:");
		double money = cin.nextDouble();
		double t = newCus.getCa().getRepayMoney();
		if((money-t)>0) {
			System.out.println("您多还了:" + (money-t) +",已返还！");
			t=money;
		}
		t=t-money;	
		newCus.getCa().setRepayMoney(t);
		System.out.println(newCus.getCa().getRepayMoney());
		System.out.println("还款成功！");
	}
	
	/*6.银行结算*/
	public static void settle() {
		if(userCa!=null) {
			newCus.getCa().assessServiceCharge();
		}
		if(userSa!=null) {
			newCus.getSa().payInterest();
		}
	}
	
	/*7.查询余额*/
	public static void queryMoney() {
		if(userCa!=null) {
			System.out.println("您的信用卡余额:" + newCus.getCa().getBalance());
		}
		if(userSa!=null) {
			System.out.println("您的存储卡余额:" + newCus.getSa().getBalance());
		}
	}
}

