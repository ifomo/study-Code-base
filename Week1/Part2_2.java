package my_first_project;

import java.util.Scanner;

public class Part2_2 {
	/*��ĿҪ�������Ƭװ�ϱ߿�ķ��ó������жԱ߿�����͡���ɫ����䡢�ĽǶ�����Ӧ���շѱ�׼��
	 *���й˿���Ҫ������Ƭ�ĳ�����Ӣ��Ϊ��λ�������͡���ɫ���Ľ�װ������������Ϣ��*/
	public static void main(String [] args) {
		Scanner cin=new Scanner(System.in);
		double cost,temp; 
		System.out.println("������߿���Ϣ");
		
		System.out.print("����(in inches)��");
		double length=cin.nextDouble();
		length+=2.0; //���ǵ��߿�����1Ӣ��
		
		System.out.print("���(in inches)��");
		double width=cin.nextDouble();
		
		System.out.print("����(regular/fancy)��");
		String type=cin.next();
		
		System.out.print("��ɫ(Ĭ�ϰ�ɫ���շ�)��");
		String color=cin.next();
		
		System.out.print("��������(0 to 4)��");
		int number=cin.nextInt();
		
		
		temp=(length+width)*2; //1Ӣ��Ŀ������������ͺͳ���һ��
		cost=temp;
		if(type.equals("regular")) //��Ҫ�Ƚ����ַ��������Ƿ���ȣ���Ҫʹ������ĺ���
			cost*=0.15;
		else if(type.equals("fancy")) 
			cost*=0.25;
		else
			System.out.println("û�и�����");
		
		if(!color.equals("white"))
			cost+=temp*0.1;
	
		cost=cost+number*0.35+temp*(0.02+0.07);
		System.out.printf("�ܷ���:%.3f",cost); //��ʽ�������ע����ʹ��printf��������Cһ��
	}
}
