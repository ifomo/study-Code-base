package my_first_project;

import java.util.Scanner;

public class Part3_1 {
	public static void main(String[] a) {
		Scanner cin = new Scanner(System.in);
		System.out.print("����Ҫ��ӡ��������");
		int n=cin.nextInt();

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n-i; j++) 
				System.out.print(" ");
			
			for (int j=1; j<=i; j++) 
				System.out.print("* ");
			
			System.out.println();
		}
	}
}
