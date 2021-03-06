package my_first_project;

import java.util.Scanner;

public class Part2_2 {
	/*题目要求计算照片装上边框的费用程序，其中对边框的类型、颜色、填充、四角都有相应的收费标准；
	 *其中顾客需要输入照片的长宽（以英寸为单位）、类型、颜色、四角装饰物数量等信息。*/
	public static void main(String [] args) {
		Scanner cin=new Scanner(System.in);
		double cost,temp; 
		System.out.println("请输入边框信息");
		
		System.out.print("长度(in inches)：");
		double length=cin.nextDouble();
		length+=2.0; //考虑到边框宽度有1英寸
		
		System.out.print("宽度(in inches)：");
		double width=cin.nextDouble();
		
		System.out.print("类型(regular/fancy)：");
		String type=cin.next();
		
		System.out.print("颜色(默认白色不收费)：");
		String color=cin.next();
		
		System.out.print("王冠数量(0 to 4)：");
		int number=cin.nextInt();
		
		
		temp=(length+width)*2; //1英寸的宽，所以最后面积就和长度一致
		cost=temp;
		if(type.equals("regular")) //想要比较两字符串内容是否相等，需要使用特殊的函数
			cost*=0.15;
		else if(type.equals("fancy")) 
			cost*=0.25;
		else
			System.out.println("没有该类型");
		
		if(!color.equals("white"))
			cost+=temp*0.1;
	
		cost=cost+number*0.35+temp*(0.02+0.07);
		System.out.printf("总费用:%.3f",cost); //格式化输出，注意是使用printf，其他和C一样
	}
}
