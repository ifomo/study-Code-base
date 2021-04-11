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
			default: System.out.println("������Ч������ѡ��");
			}
			choice = mainMeun();
		}
		System.out.println("============��ӭ�´�ʹ�ã�============");
		return;
		/*CheckingAccount userCa = new CheckingAccount(); //null;  //new CheckingAccount("12345", 5000, 12.3);
		userCa = new CheckingAccount("12345", 5000, 12.3);  //�����ٴγ�ʼ����
		System.out.println(userCa.toString());*/  //���userCa==null��������÷����ᱨ��
	}
	
	/*���˵�*/
	public static int mainMeun() {
		System.out.println("==========��ӭʹ������ϵͳ��==========");
		System.out.println("1.����");
		System.out.println("2.���");
		System.out.println("3.ȡ��");
		System.out.println("4.����");
		System.out.println("5.����");
		System.out.println("6.���н���");
		System.out.println("7.��ѯ���");
		System.out.println("8.�˳�");
		
		System.out.println("����������ѡ��(1-8):");
		int choice = cin.nextInt();
		return choice;
	}
	
	/*�����˵�*/
	public static int subMeun() {
		System.out.println("==========��ѡ�񿪿����ͣ�==========");
		System.out.println("1.���ÿ�");
		System.out.println("2.��");
		System.out.println("3.�������˵�");
		/*�������ſ���Ҫ���𣿵������ǵ�Customer��Ĺ��췽���������ſ��ࣻ
		 *��ʵ����˵���Բ�һ�����죬�������ǿ���ʹ���޲������췽������ʼ�������Ŀ���*/
		
		System.out.println("����������ѡ��(1-3):");
		int choice = cin.nextInt();
		return choice;
	}
	
	/*1.����*/
	public static void createNewcustomer() {
		int choose = subMeun();
//		CheckingAccount userCa = null; //new CheckingAccount();
//		SavingsAccount userSa = null; //new SavingsAccount();
		
		String ssn="��", name="��";
		/*System.out.print("���������֤��:");
		String ssn = cin.next();
		System.out.print("����������:");
		String name = cin.next();*/
		
		while(choose!=3) {
			if(choose==1) {
				if(userCa!=null) {
					System.out.println("�ѿ������ÿ����ص�ѡ��ҳ��...");
				}
				else {
					System.out.print("���������֤��:");
					ssn = cin.next();
					System.out.print("����������:");
					name = cin.next();
					System.out.print("���������ÿ�����:");
					String accountNum = cin.next();
					System.out.print("����������:");
					double serviceCharge = cin.nextDouble();
					userCa = new CheckingAccount(accountNum, 10000, serviceCharge);//����ʼΪ10000
				}
			}
			else if(choose==2) {
				if(userSa!=null) {
					System.out.println("�ѿ���洢�����ص�ѡ��ҳ��...");
				}
				else {
					System.out.print("���������֤��:");
					ssn = cin.next();
					System.out.print("����������:");
					name = cin.next();
					System.out.print("������洢������:");
					String accountNum = cin.next();
					System.out.print("����������:");
					double interestRate = cin.nextDouble();
					userSa = new SavingsAccount(accountNum, 0.0, interestRate);
				}
			}
			else {
				System.out.println("����ѡ��������������롣");
			}
			choose = subMeun();
		}
		newCus = new Customer(ssn, name, userCa, userSa);
	}
	
	/*2.���*/
	public static void saveMoney() {
//		System.out.println("������洢������:");  
//Ŀǰ��ֻ�Ǽ򵥵ĵ��û�Ӧ�ã���ͻ��빤����Ա�Ĳ�ͬȨ�޿��ơ��û���֤����...��δ��ʼ������
		if(userSa==null) {
			System.out.println("��Ǹ������δ����洢�����ص���ҳ��...");
			return;
		}
		System.out.println("����������:");
		double money = cin.nextDouble();
		double t = newCus.getSa().getBalance();
		newCus.getSa().setBalance(t+money);
		System.out.println("���ɹ���");
	}
	
	/*3.ȡ��*/
	public static void withDrawmoney() {
		if(userSa==null) {
			System.out.println("��Ǹ������δ����洢�����ص���ҳ��...");
			return;
		}
		System.out.println("������ȡ����:");
		double money = cin.nextDouble();
		double t = newCus.getSa().getBalance();
		if(money > t) {
			System.out.println("��Ǹ���������㣡�ص���ҳ��...");
		}
		else {
			newCus.getSa().setBalance(t-money);
			System.out.println("ȡ��ɹ���");
		}
	}
	
	/*4.����--���ÿ�*/
	public static void comsume() {
		if(userCa==null) {
			System.out.println("��Ǹ������δ�������ÿ����ص���ҳ��...");
			return;
		}
		System.out.println("���������ѽ��:");
		double money = cin.nextDouble();
		double t = newCus.getCa().getBalance();
		if(money > t) {
			System.out.println("��Ǹ���������㣡�ص���ҳ��...");
		}
		else {
			newCus.getCa().setBalance(t-money);
			t=newCus.getCa().getRepayMoney();
			newCus.getCa().setRepayMoney(t+money+newCus.getCa().getServiceCharge());
			//����һ�Σ����������һ��
			System.out.println("���ѳɹ���");
		}
	}
	
	/*5.����--���ÿ�*/
	public static void repay() {
		if(userCa==null) {
			System.out.println("��Ǹ������δ�������ÿ����ص���ҳ��...");
			return;
		}
		System.out.println("�����뻹����:");
		double money = cin.nextDouble();
		double t = newCus.getCa().getRepayMoney();
		if((money-t)>0) {
			System.out.println("���໹��:" + (money-t) +",�ѷ�����");
			t=money;
		}
		t=t-money;	
		newCus.getCa().setRepayMoney(t);
		System.out.println(newCus.getCa().getRepayMoney());
		System.out.println("����ɹ���");
	}
	
	/*6.���н���*/
	public static void settle() {
		if(userCa!=null) {
			newCus.getCa().assessServiceCharge();
		}
		if(userSa!=null) {
			newCus.getSa().payInterest();
		}
	}
	
	/*7.��ѯ���*/
	public static void queryMoney() {
		if(userCa!=null) {
			System.out.println("�������ÿ����:" + newCus.getCa().getBalance());
		}
		if(userSa!=null) {
			System.out.println("���Ĵ洢�����:" + newCus.getSa().getBalance());
		}
	}
}

