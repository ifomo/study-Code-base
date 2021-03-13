package my_first_project;

import java.util.Scanner;

public class Part2_1 {
	public static void main(String [] args) {
		Scanner cin=new Scanner(System.in);
		System.out.print("输入待兑换美元：");
		double moneyTchange=cin.nextDouble(); 
		int Tocent=(int)(moneyTchange*100); //将美元化成美分为单位
		int temp;
			
		
		/*方法一：逐一兑换，但是每次的if语句都差不多*/
		/*if((temp=Tocent/100)!=0) {
			System.out.println("美元："+temp+"个");
			Tocent%=100;
		}
		if((temp=Tocent/50)!=0) {
			System.out.println("50美分："+temp+"个");
			Tocent%=50;
		}
		if((temp=Tocent/20)!=0) {
			System.out.println("20美分："+temp+"个");
			Tocent%=20;
		}
		if((temp=Tocent/10)!=0) {
			System.out.println("10美分："+temp+"个");
			Tocent%=10;
		}
		if((temp=Tocent/5)!=0) {
			System.out.println("5美分："+temp+"个");
		}*/
		
		
		/*方法二：兑换的美分为--50美分、20、10、5，差不多是折本递减的；
		又由于每次的操作类似，干脆直接用一个while循环一直进行；
		或者可以考虑递归的方法。*/
		int coin=100;
		while(true) {
			temp=Tocent/coin;
			if (temp!=0)
				System.out.println(coin+"美分："+temp+"个");
			Tocent%=coin;
			coin/=2;
			
			if(coin==25)
				coin-=5;
			
			else if(coin<5)
				break;
		}
		if(Tocent!=0)
			System.out.println("剩余"+Tocent+"美分无法兑换");
	}
}
