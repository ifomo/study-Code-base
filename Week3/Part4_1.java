package my_first_project;

import java.util.Scanner;

public class Part4_1 {
	/*������*/
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
				System.out.println("ƽ����:" + aver); break;
			case 3: 
				double high=highestGrade();
				System.out.println("��߷�:" + high); break;
			case 4: 
				double low=LowestGrade(); 
				System.out.println("��ͷ�:" + low); break;
			case 5:
				sortGrade();
				System.out.print("����:");
				for(int i=0; i<studentsGrade.length; i++)
					System.out.print(studentsGrade[i]+" ");
				System.out.println(); break;
			default: System.out.println("������Ч������ѡ��");
			}
			
			System.out.print("�ٴ��������ѡ��(1~6):");
			choose = cin.nextInt();
		}
		System.out.println("=====================");
		System.out.println("���˳����򣬻�ӭ�´�ʹ�ã�");
	}
	
	
	/*���˵�*/
	public static int menu(){
		System.out.println("========== WTU-Student-Grade-System ==========");
		System.out.println("1.ѧ���ɼ�¼��(0~100):");
		System.out.println("2.��ƽ����");
		System.out.println("3.����߷�");
		System.out.println("4.����ͷ�");
		System.out.println("5.�ɼ���С��������"); 
		System.out.println("6.�����˳�");
		
		System.out.print("�������ѡ��(1~6):");
		int choice = cin.nextInt();
		return choice;
	}
	
	
	public static void enterGrade(){
		studentsGrade = new double[5];
		for(int i=0; i<studentsGrade.length; i++){
			double t=cin.nextDouble();
			while(t<0.0 || t>100.0){
				System.out.print("����ɼ���Ч����������:");
				t=cin.nextDouble();
			}
			studentsGrade[i]=t;
		}
	}
	
	public static double average(){
		if(studentsGrade==null){
			System.out.println("��ѧ���ɼ�������¼��(0~100):");
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
			System.out.println("��ѧ���ɼ�������¼��(0~100):");
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
			System.out.println("��ѧ���ɼ�������¼��(0~100):");
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
		/*ð������*/
		for(int i=0; i<studentsGrade.length-1; i++)
			for(int j=0; j<studentsGrade.length-1-i; j++)
				if(studentsGrade[j+1]<studentsGrade[j]){
					double temp=studentsGrade[j+1];
					studentsGrade[j+1]=studentsGrade[j];
					studentsGrade[j]=temp;
				}
	}
}
