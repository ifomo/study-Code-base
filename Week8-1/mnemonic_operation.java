package Week_Eight;

import java.util.Scanner;

/*��д��������Ʒ����ʽ�������㣺
 *��ʽlike add(12.0,3.0)=15.0��sub(4.0,2.0)=2.0��doubleMe(12)=24
 *2021.4.20--����--��ϰ2*/
public class mnemonic_operation {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("�������Ʒ�������ʽ:");
//		String mnemonicOp = cin.next();  //���뺬�пո�ʹ��nextLine
		String mnemonicOp = cin.nextLine();
		int pos1 = mnemonicOp.indexOf("(");
		int pos2 = mnemonicOp.indexOf(",");  //�������Ҳ���������-1
		int pos3 = mnemonicOp.indexOf(")");
		String opMn = mnemonicOp.substring(0, pos1);
		double number1=0, number2=0;
		
		/*��ƽ�����㣺��ֱ�ӽ����ˣ�Ҳ����Ҫ�ڽ��к�������������ж�*/
		if(opMn.equals("doubleMe")) {
			String t = mnemonicOp.substring(pos1+1, pos3);
			t = t.trim();  //ȥ�����ҿո�
			number1 = Double.parseDouble(t);
			System.out.println(mnemonicOp + "=" + (2*number1));
			return;
		}
		/*ȡ���ӡ���������������*/
		else if(opMn.equals("add") || opMn.equals("sub")) {
			String t = mnemonicOp.substring(pos1+1, pos2);
//			t = t.trim();
			number1 = Double.parseDouble(t);  //��ʹ���пո�Ҳ�޷���
			t = mnemonicOp.substring(pos2+1, pos3);
//			t = t.trim();
			number2 = Double.parseDouble(t);
		}
		else 
			System.out.println("No such operation!");
		
		/*�������Ƿ�����ǰ��ȡ���Ĳ��������ж�Ӧ������*/
		switch(opMn) {
		case "add": System.out.println(mnemonicOp + "=" + (number1+number2)); break;
		case "sub": System.out.println(mnemonicOp + "=" + (number1-number2)); break;
		default: System.out.println("No such operation!"); break;
		}
	}
}
