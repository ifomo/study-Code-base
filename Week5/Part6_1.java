package Week_Five;

import java.util.Scanner;

public class Part6_1 {
	static public Scanner cin = new Scanner(System.in);
	public static void main(String a[]){
		System.out.print("��������Ŀ����");
		String projectName = cin.next();
		System.out.print("������Ԥ�㣺");
		float budget = cin.nextFloat();
		
		Employee emp1 = null;  //�ȸ���ֵΪ�գ������35�б���
		Employee emp2 = null;
		int i=1;
		while(i < 3) {
			System.out.println("������Ա��" + i + "����Ϣ��");
			System.out.print("id�ţ�"); 
			String id = cin.next();
			System.out.print("������");
			String name = cin.next();
			System.out.print("���ţ�");
			String department = cin.next();
			System.out.print("н�ʣ�");
			float salary = cin.nextFloat();
			if(i==1) {
				emp1 = new Employee(id, name, department, salary);
			}	
			else if(i==2)
				emp2 = new Employee(id, name, department, salary);
			i++;
		}
		
		Project pro = new Project(projectName, budget, emp1, emp2);
		System.out.println(pro.toString());
		System.out.println("\n");
		
		System.out.print("��ΪԱ��н�������ٷ�֮��");
		float rate = cin.nextInt();
		budget += emp1.getSalary()*(rate/100) + emp2.getSalary()*(rate/100);
		emp1.updateSalary(rate);
		emp2.updateSalary(rate);
		pro.setBudget(budget);
		System.out.print("��Ԥ����Ҫ���ӣ�" + budget + "\n");
		System.out.println(pro);  //�Զ�����toString()����
		
		//�����͵ĳ���100���õ��Ļ�������������20/100=0;
		//��ʹ��ǰ��ǿ������ת����Ҳֻ�����͵Ľ���ϸ��㻯;
		//����ֱ�ӽ�rate����Ϊ�����͡�
		/*float rate = cin.nextInt();  
//		int rate = cin.nextInt();
		float t= (rate/100);
//		int t = (float)(rate/100);
		System.out.println(t);*/  
	}
}
