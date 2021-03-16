package my_first_project;

import java.util.Scanner;

public class Part3_3 {
	public static void main(String[] a) {
		Scanner cin = new Scanner(System.in);
		String choose;
		do {
			int myNum, yourNum;
			myNum = 1+(int)(Math.random()*1000);
			//System.out.println(myNum);
			//Math.random()方法随机生成0~1之间的小数

			System.out.println("我给出一个随机数，范围在0~1000之间;");
			System.out.println("玩猜数游戏，你有5次机会，输入你的数:");

			for (int i=1; i<=5; i++) {
				yourNum = cin.nextInt();

				if(yourNum == myNum) {
					System.out.println("恭喜，你猜对了!");
					break;
				} 
				else {
					if(yourNum < myNum) 
						System.out.println("你猜低了!");
					else 
						System.out.println("你猜高了!");
				}
				System.out.println("剩余猜测次数为：" + (5-i));
			} 

			System.out.println("是否再玩一次？(yes / no)");
			choose = cin.next();

		} while (choose.equals("yes"));
		System.out.println("游戏结束!");
	}
}