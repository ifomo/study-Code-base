package Week_Eight;

import java.util.Scanner;

/*Ҫ�󣺱�д���򣬶�����--2+3, 4-2������������ʽ��⣻
 *˼·���������ַ�����split���������ݱ��ʽ�еĲ����������������ʹ��������ʽ���ɣ�
 *Ȼ���ȡ��������ȷ��ִ�к������㡣
 *2021.4.20--����--��ϰ1*/
public class expression_operation {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("����������ʽ:");
		String expressionOp = cin.next();
		
		/*���Һ����ڲ�������������ʽ��������ͼһ�仰���ܲ��ҵ�������ǲ����е�*/
//		String operator = expressionOp.indexOf("-")  
		
		/*���ݼӼ��˳����ţ��������������������ȷ������ʽ��ʽ��
		 *�Ӽ��˳�����ȷת����ţ�'\\+', '\\-', '\\*', '/' */
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
