package my_first_project;

import java.util.Scanner;

public class Part3_1 {
	public static void main(String[] a) {
		Scanner cin = new Scanner(System.in);
		System.out.print("输入要打印的行数：");
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
