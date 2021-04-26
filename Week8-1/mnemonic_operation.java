package Week_Eight;

import java.util.Scanner;

/*编写程序对助计符表达式进行运算：
 *形式like add(12.0,3.0)=15.0、sub(4.0,2.0)=2.0、doubleMe(12)=24
 *2021.4.20--机房--练习2*/
public class mnemonic_operation {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("输入助计符运算表达式:");
//		String mnemonicOp = cin.next();  //输入含有空格，使用nextLine
		String mnemonicOp = cin.nextLine();
		int pos1 = mnemonicOp.indexOf("(");
		int pos2 = mnemonicOp.indexOf(",");  //倘若查找不到，返回-1
		int pos3 = mnemonicOp.indexOf(")");
		String opMn = mnemonicOp.substring(0, pos1);
		double number1=0, number2=0;
		
		/*求平方运算：就直接进行了，也不需要在进行后面其他情况的判断*/
		if(opMn.equals("doubleMe")) {
			String t = mnemonicOp.substring(pos1+1, pos3);
			t = t.trim();  //去掉左右空格
			number1 = Double.parseDouble(t);
			System.out.println(mnemonicOp + "=" + (2*number1));
			return;
		}
		/*取出加、减的两个操作数*/
		else if(opMn.equals("add") || opMn.equals("sub")) {
			String t = mnemonicOp.substring(pos1+1, pos2);
//			t = t.trim();
			number1 = Double.parseDouble(t);  //即使含有空格，也无妨！
			t = mnemonicOp.substring(pos2+1, pos3);
//			t = t.trim();
			number2 = Double.parseDouble(t);
		}
		else 
			System.out.println("No such operation!");
		
		/*根据助记符，对前面取出的操作数进行对应的运算*/
		switch(opMn) {
		case "add": System.out.println(mnemonicOp + "=" + (number1+number2)); break;
		case "sub": System.out.println(mnemonicOp + "=" + (number1-number2)); break;
		default: System.out.println("No such operation!"); break;
		}
	}
}
