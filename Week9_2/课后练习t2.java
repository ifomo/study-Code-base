package Lesson11;

import java.util.regex.Matcher;
//import java.util.Scanner;
import java.util.regex.Pattern;

public class 课后练习t2 {
	public static void main(String[] args) {
//		Scanner cin = new Scanner(System.in);
		String op = "add(5,min(10,sub(5,2)))";
//		String op = "add(5,max(13,2))";
//		String op = "add(3,4)";
//		String op = "doubleMe(4)";
//		String op = "doubleMe(add(3,sub(7,2)))";
		String regx = "(.*?)(add|sub|max|min|doubleMe)\\((.+?)\\)";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(op);
		//非要先m.matches()一下，后面的group()方法才有效，why？？？
		/*if(m.matches())
			System.out.println("right");
		System.out.println(m.group(2));  //助计符
		System.out.println(m.group(3));  //括号内操作数*/

		boolean has = m.find();
		while(has) {
			System.out.println(m.group(3));
			has = m.find();
		}
		
//		System.out.println("end="+ regxOperation(p, op));
	}
	
	/*对表达式递归处理运算*/
	public static double regxOperation(Pattern p, String op) {
		double end = 0;
		Matcher m = p.matcher(op);
		Matcher m2 = null;
		//为了下面的m.group()起作用，先m.matches()一下
		if(m.matches()) 
			m2 = p.matcher(m.group(3));
		
		/*递归到最后，m.group(3)的值，就单单只剩下两个操作数了；
		 *无法执行else出口条件下的语句，所以我们用下一跳做判断；
		 *这样保证递归出口，到最后类似add(2,3)可计算形式*/
		if(m2.matches()) {  
			String d = "";
			if(!(m.group(2)).equals("doubleMe")) {
				String h[] = m.group(3).split(",");
				d = h[0]+",";
			}
			double t = regxOperation(p, m.group(3));
			String opNumber = d + String.valueOf(t);  //doubleMe时，就只考虑t操作数
			end = helpOperation(m.group(2), opNumber);
		}
		else 
			end = helpOperation(m.group(2), m.group(3));
		return end;
	}
	
	/*助计符表达式运算：分别传入助计符、操作数两个字符串参数*/
	public static double helpOperation(String help, String opNumber) {
		double end = 0, num1 = 0, num2 = 0;
		if(opNumber.indexOf(",")!=-1) {
			String d[] = opNumber.split(",");
			num1 = Double.parseDouble(d[0]);
			num2 = Double.parseDouble(d[1]);
		}
		else
			num1 = Double.parseDouble(opNumber);

		switch(help) {
		case "add": end = num1+num2; break;
		case "sub": end = num1-num2; break;
		case "max": end = (num1>num2) ? num1:num2; break;
		case "min": end = (num1<num2) ? num1:num2; break;
		case "doubleMe": end = num1*num1; break;
		default: return 0;
		}
		return end;
	}
}

