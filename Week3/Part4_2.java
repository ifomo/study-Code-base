package my_first_project;

import java.util.Scanner;

public class Part4_2 {
	/*������*/
	public static Scanner cin = new Scanner(System.in);
	public static int firstNum, secondNum;
	public static boolean temp = false; 
	//ֻ���������������ݴ�С�����һ��С�ڵڶ������Ż��Ϊtrue
	
	public static void main(String[] a){
		int choose=menu();
		while(choose!=6){
			switch(choose){
			case 1: enterNum(); break;
			case 2: 
				if(!temp) {
					System.out.println("�޳�ʼ����������¼�룡");
					break;
				}
				oddNum(); break;
			case 3: 
				if(!temp) {
					System.out.println("�޳�ʼ����������¼�룡");
					break;
				}
				evenSum(); break;
			case 4: one_tenSquares(); break;
			case 5: 
				if(!temp) {
					System.out.println("�޳�ʼ����������¼�룡");
					break;
				}
				odd_sumSquares(); break;
			default: System.out.println("������Ч������ѡ��");
			}
			
			System.out.println("=====================");
			System.out.print("�ٴ��������ѡ��(1~6):");
			choose = cin.nextInt();
		}
		System.out.println("========== Exit ==========");
		System.out.println("���˳����򣬻�ӭ�´�ʹ�ã�");
	}
	
	
	/*���˵�*/
	public static int menu(){
		System.out.println("========== System-Menu ==========");
		System.out.println("1.Enter firstNUm and secondNum.");
		System.out.println("2.firstNUm �� secondNum ֮�����е�����.");
		System.out.println("3.firstNUm �� secondNum ֮�����е�ż��֮��.");
		System.out.println("4.1��10֮�����е��������ǵ�ƽ��.");
		System.out.println("5.firstNUm �� secondNum ֮����������ƽ��֮��.");
		//System.out.println("6.�������еĴ�д��ĸ(ʹ�� ASCII).");
		System.out.println("6.�����˳�.");
		
		System.out.print("�������ѡ��(1~6):");
		int choice = cin.nextInt();
		return choice;
	}
	
	
	public static void enterNum(){
		while(!temp){
			System.out.print("firstNum=");
			firstNum = cin.nextInt();
			
			System.out.print("secondNum=");
			secondNum = cin.nextInt();
			
			if(firstNum > secondNum)
				System.out.println("��һ����������С�ڵڶ������ٴ�����:");
			else
				temp = true;
		}
	}
	
	public static void oddNum(){
		for(int i=firstNum; i<=secondNum; i++){
			if(i%2!=0)
				System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void evenSum(){
		int sum=0;
		for(int i=firstNum; i<=secondNum; i++){
			if(i%2==0)
				sum+=i;
		}
		System.out.println("ż��֮��:" + sum);
	}
	
	public static void one_tenSquares(){
		int sum=0;
		for(int i=1; i<=10; i++){
			sum+=Math.pow(i, 2);
		}
		System.out.println("sum=" + sum);
	}
	
	public static void odd_sumSquares(){
		int sum=0;
		for(int i=firstNum; i<=secondNum; i++){
			if(i%2!=0)
				sum+=Math.pow(i, 2);
		}
		System.out.println("sum=" + sum);
	}
}

