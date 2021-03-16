package my_first_project;

import java.util.Scanner;

public class Part4_2 {
	/*主函数*/
	public static Scanner cin = new Scanner(System.in);
	public static int firstNum, secondNum;
	public static boolean temp = false; 
	//只有输入数据且数据大小满足第一个小于第二个，才会变为true
	
	public static void main(String[] a){
		int choose=menu();
		while(choose!=6){
			switch(choose){
			case 1: enterNum(); break;
			case 2: 
				if(!temp) {
					System.out.println("无初始整数，请先录入！");
					break;
				}
				oddNum(); break;
			case 3: 
				if(!temp) {
					System.out.println("无初始整数，请先录入！");
					break;
				}
				evenSum(); break;
			case 4: one_tenSquares(); break;
			case 5: 
				if(!temp) {
					System.out.println("无初始整数，请先录入！");
					break;
				}
				odd_sumSquares(); break;
			default: System.out.println("输入无效，重新选择！");
			}
			
			System.out.println("=====================");
			System.out.print("再次输入你的选择(1~6):");
			choose = cin.nextInt();
		}
		System.out.println("========== Exit ==========");
		System.out.println("已退出程序，欢迎下次使用！");
	}
	
	
	/*主菜单*/
	public static int menu(){
		System.out.println("========== System-Menu ==========");
		System.out.println("1.Enter firstNUm and secondNum.");
		System.out.println("2.firstNUm 和 secondNum 之间所有的奇数.");
		System.out.println("3.firstNUm 和 secondNum 之间所有的偶数之和.");
		System.out.println("4.1到10之间所有的数和它们的平方.");
		System.out.println("5.firstNUm 和 secondNum 之间所有奇数平方之和.");
		//System.out.println("6.输入所有的大写字母(使用 ASCII).");
		System.out.println("6.程序退出.");
		
		System.out.print("输入你的选择(1~6):");
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
				System.out.println("第一个整数必须小于第二个！再次输入:");
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
		System.out.println("偶数之和:" + sum);
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

