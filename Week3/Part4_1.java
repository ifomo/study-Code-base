package my_first_project;

import java.util.Scanner;

public class Part4_1 {
	/*主函数*/
	public static Scanner cin = new Scanner(System.in);
	public static double studentsGrade[] = null; //new double[5];
	
	public static void main(String[] a){
		int choose=menu();
		while(choose!=6){
			switch(choose){
			case 1: 
				enterGrade(); break;
			case 2: 
				double aver=average(); 
				System.out.println("平均分:" + aver); break;
			case 3: 
				double high=highestGrade();
				System.out.println("最高分:" + high); break;
			case 4: 
				double low=LowestGrade(); 
				System.out.println("最低分:" + low); break;
			case 5:
				sortGrade();
				System.out.print("排序:");
				for(int i=0; i<studentsGrade.length; i++)
					System.out.print(studentsGrade[i]+" ");
				System.out.println(); break;
			default: System.out.println("输入无效，重新选择！");
			}
			
			System.out.print("再次输入你的选择(1~6):");
			choose = cin.nextInt();
		}
		System.out.println("=====================");
		System.out.println("已退出程序，欢迎下次使用！");
	}
	
	
	/*主菜单*/
	public static int menu(){
		System.out.println("========== WTU-Student-Grade-System ==========");
		System.out.println("1.学生成绩录入(0~100):");
		System.out.println("2.求平均分");
		System.out.println("3.求最高分");
		System.out.println("4.求最低分");
		System.out.println("5.成绩从小到大排序"); 
		System.out.println("6.程序退出");
		
		System.out.print("输入你的选择(1~6):");
		int choice = cin.nextInt();
		return choice;
	}
	
	
	public static void enterGrade(){
		studentsGrade = new double[5];
		for(int i=0; i<studentsGrade.length; i++){
			double t=cin.nextDouble();
			while(t<0.0 || t>100.0){
				System.out.print("输入成绩无效，重新输入:");
				t=cin.nextDouble();
			}
			studentsGrade[i]=t;
		}
	}
	
	public static double average(){
		if(studentsGrade==null){
			System.out.println("无学生成绩！请先录入(0~100):");
			enterGrade();
		}
		double sum=0.0;
		for(int i=0; i<studentsGrade.length; i++){
			sum+=studentsGrade[i];
		}
		return sum/5;
		
	}
	
	public static double highestGrade(){
		if(studentsGrade==null){
			System.out.println("无学生成绩！请先录入(0~100):");
			enterGrade();
		}
		double high=studentsGrade[0];
		for(int i=1; i<studentsGrade.length; i++){
			if(studentsGrade[i] > high)
				high=studentsGrade[i];
		}
		return high;
	}
	
	public static double LowestGrade(){
		if(studentsGrade==null){
			System.out.println("无学生成绩！请先录入(0~100):");
			enterGrade();
		}
		double low=studentsGrade[0];
		for(int i=1; i<studentsGrade.length; i++){
			if(studentsGrade[i] < low)
				low=studentsGrade[i];
		}
		return low;
	}
	
	public static void sortGrade(){
		/*冒号排序*/
		for(int i=0; i<studentsGrade.length-1; i++)
			for(int j=0; j<studentsGrade.length-1-i; j++)
				if(studentsGrade[j+1]<studentsGrade[j]){
					double temp=studentsGrade[j+1];
					studentsGrade[j+1]=studentsGrade[j];
					studentsGrade[j]=temp;
				}
	}
}
