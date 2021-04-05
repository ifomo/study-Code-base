package Week_Five;

import java.util.Scanner;

public class Part6_1 {
	static public Scanner cin = new Scanner(System.in);
	public static void main(String a[]){
		System.out.print("请输入项目名：");
		String projectName = cin.next();
		System.out.print("请输入预算：");
		float budget = cin.nextFloat();
		
		Employee emp1 = null;  //先赋初值为空，否则第35行报错！
		Employee emp2 = null;
		int i=1;
		while(i < 3) {
			System.out.println("请输入员工" + i + "的信息：");
			System.out.print("id号："); 
			String id = cin.next();
			System.out.print("姓名：");
			String name = cin.next();
			System.out.print("部门：");
			String department = cin.next();
			System.out.print("薪资：");
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
		
		System.out.print("现为员工薪资增长百分之：");
		float rate = cin.nextInt();
		budget += emp1.getSalary()*(rate/100) + emp2.getSalary()*(rate/100);
		emp1.updateSalary(rate);
		emp2.updateSalary(rate);
		pro.setBudget(budget);
		System.out.print("故预算需要增加：" + budget + "\n");
		System.out.println(pro);  //自动调用toString()方法
		
		//用整型的除以100，得到的会是整数，比如20/100=0;
		//即使再前面强制类型转换，也只是整型的结果上浮点化;
		//所以直接将rate定义为浮点型。
		/*float rate = cin.nextInt();  
//		int rate = cin.nextInt();
		float t= (rate/100);
//		int t = (float)(rate/100);
		System.out.println(t);*/  
	}
}
