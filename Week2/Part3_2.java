package my_first_project;

import java.util.Scanner;

//�������nλˮ�ɻ�����
public class Part3_2 {
	public static void main(String[] a) {
		Scanner cin=new Scanner(System.in);
		int n,S;
		S=0;
		
		System.out.println("Enter n:(3<=n<=7)");
		n=cin.nextInt(); 
		for(int i=(int)Math.pow(10, n-1); i<Math.pow(10, n); i++) {
			int temp=i;
			while(temp!=0) {
				S+=Math.pow(temp%10, n);
				temp/=10;
			}
			if(S==i)
				System.out.println(i);
			S=0;
		}
	}
}
