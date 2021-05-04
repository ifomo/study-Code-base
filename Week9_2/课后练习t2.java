package Lesson11;

import java.util.regex.Matcher;
//import java.util.Scanner;
import java.util.regex.Pattern;

public class �κ���ϰt2 {
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
		//��Ҫ��m.matches()һ�£������group()��������Ч��why������
		/*if(m.matches())
			System.out.println("right");
		System.out.println(m.group(2));  //���Ʒ�
		System.out.println(m.group(3));  //�����ڲ�����*/

		boolean has = m.find();
		while(has) {
			System.out.println(m.group(3));
			has = m.find();
		}
		
//		System.out.println("end="+ regxOperation(p, op));
	}
	
	/*�Ա��ʽ�ݹ鴦������*/
	public static double regxOperation(Pattern p, String op) {
		double end = 0;
		Matcher m = p.matcher(op);
		Matcher m2 = null;
		//Ϊ�������m.group()�����ã���m.matches()һ��
		if(m.matches()) 
			m2 = p.matcher(m.group(3));
		
		/*�ݹ鵽���m.group(3)��ֵ���͵���ֻʣ�������������ˣ�
		 *�޷�ִ��else���������µ���䣬������������һ�����жϣ�
		 *������֤�ݹ���ڣ����������add(2,3)�ɼ�����ʽ*/
		if(m2.matches()) {  
			String d = "";
			if(!(m.group(2)).equals("doubleMe")) {
				String h[] = m.group(3).split(",");
				d = h[0]+",";
			}
			double t = regxOperation(p, m.group(3));
			String opNumber = d + String.valueOf(t);  //doubleMeʱ����ֻ����t������
			end = helpOperation(m.group(2), opNumber);
		}
		else 
			end = helpOperation(m.group(2), m.group(3));
		return end;
	}
	
	/*���Ʒ����ʽ���㣺�ֱ������Ʒ��������������ַ�������*/
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

