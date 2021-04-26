package Week_Eight;

import java.util.Scanner;

/*要求：编写程序，对形如--2+3, 4-2的算数运算表达式求解；
 *思路：可以用字符串的split方法，依据表达式中的操作符分离操作数，使用正则表达式即可；
 *然后获取操作符，确定执行何种运算。
 *2021.4.20--机房--练习1*/
public class expression_operation {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("输入运算表达式:");
		String expressionOp = cin.next();
		
		/*查找函数内部并不是正则表达式，所以妄图一句话就能查找到运算符是不可行的*/
//		String operator = expressionOp.indexOf("-")  
		
		/*根据加减乘除符号，分离出操作数的两种正确正则表达式形式；
		 *加减乘除的正确转义符号：'\\+', '\\-', '\\*', '/' */
//		String[] opNumber = expressionOp.split("\\+|\\-|\\*|/");
		
		String[] opNumber = expressionOp.split("[+\\-*/]");
		double t1 = Double.parseDouble(opNumber[0]);
		double t2 = Double.parseDouble(opNumber[1]);
		double end = 0;
		char t;
		
		for(int i=0; i<expressionOp.length(); i++) {
			t = expressionOp.charAt(i);
			if(t=='+') {
				end = t1+t2;
				break;
			}
			else if(t=='-') {
				end = t1-t2;
				break;
			}
			else if(t=='*') {
				end = t1*t2;
				break;
			}
			else if(t=='/') {
				end = t1/t2;
				break;
			}
		}
		
		System.out.println(expressionOp +"="+ end);
	}
}
