package my_first_project;

import java.util.Scanner;

public class Part2_1 {
	public static void main(String [] args) {
		Scanner cin=new Scanner(System.in);
		System.out.print("������һ���Ԫ��");
		double moneyTchange=cin.nextDouble(); 
		int Tocent=(int)(moneyTchange*100); //����Ԫ��������Ϊ��λ
		int temp;
			
		
		/*����һ����һ�һ�������ÿ�ε�if��䶼���*/
		/*if((temp=Tocent/100)!=0) {
			System.out.println("��Ԫ��"+temp+"��");
			Tocent%=100;
		}
		if((temp=Tocent/50)!=0) {
			System.out.println("50���֣�"+temp+"��");
			Tocent%=50;
		}
		if((temp=Tocent/20)!=0) {
			System.out.println("20���֣�"+temp+"��");
			Tocent%=20;
		}
		if((temp=Tocent/10)!=0) {
			System.out.println("10���֣�"+temp+"��");
			Tocent%=10;
		}
		if((temp=Tocent/5)!=0) {
			System.out.println("5���֣�"+temp+"��");
		}*/
		
		
		/*���������һ�������Ϊ--50���֡�20��10��5��������۱��ݼ��ģ�
		������ÿ�εĲ������ƣ��ɴ�ֱ����һ��whileѭ��һֱ���У�
		���߿��Կ��ǵݹ�ķ�����*/
		int coin=100;
		while(true) {
			temp=Tocent/coin;
			if (temp!=0)
				System.out.println(coin+"���֣�"+temp+"��");
			Tocent%=coin;
			coin/=2;
			
			if(coin==25)
				coin-=5;
			
			else if(coin<5)
				break;
		}
		if(Tocent!=0)
			System.out.println("ʣ��"+Tocent+"�����޷��һ�");
	}
}
