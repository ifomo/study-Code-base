package Week_Five;

import java.util.Scanner;

/*Part6_2:驱动类；
* 使用到: Student、Subject、ClassList类；
* 构建一个学生列表系统，显示学年学期，显示当前学期开设课程，选修该课程的学生等信息。*/
public class Part6_2 {
	/*全局变量如果加了static，那么下面的函数要想使用全局变量，它也得加上static；
	 *同理，一般我们都是将main函数设为static，所以全局或其函数也得这样，不然就用不了；
	 *我发现全都去掉static后，程序并不会执行，而是执行上一次我结束的程序？*/
	static public Scanner cin = new Scanner(System.in);
	static private ClassList L1 = null;
	public static void main(String a[]){
		chooseMenu();
		System.out.println("请输入您的操作选择：");
		int choice = cin.nextInt();
		while(choice!=3){
			switch(choice){
			case 1: createList(); break;
			case 2: printList(); break;
			default: System.out.println("你在干啥呢？"); 
			}
			System.out.println("再次输入您的操作选择：");
			choice = cin.nextInt();
		}
		System.out.println("欢迎下次光临！");
	}
	
	static public void chooseMenu(){
		System.out.println("==========Holmesglen's computer system==========");
		System.out.println("1.create list");
		System.out.println("2.print list");
		System.out.println("3.exit");
		System.out.println("================================================");
	}
	
	static public void createList(){
		if(L1 != null) {
			System.out.println("列表已创建，确定继续创建？(yes/no):");
			String temp = cin.next();
			if(temp.equals("no")){
				return;  //退出方法
			}
		}
		
		System.out.println("输入学年：");
		int year = cin.nextInt();
		System.out.println("输入学期(1/2)：");
		int semester = cin.nextInt();
		
		System.out.println("输入课程号：");
		String subId = cin.next();
		System.out.println("输入课程名：");
		String subName = cin.next();
		Subject subj = new Subject(subId, subName);
		
		System.out.println("输入学生1的学号：");
		String stuId1 = cin.next();
		System.out.println("输入学生1的姓名：");
		String stuName1 = cin.next();
		Student s1 = new Student(stuId1, stuName1);
		
		System.out.println("输入学生2的学号：");
		String stuId2 = cin.next();
		System.out.println("输入学生2的姓名：");
		String stuName2 = cin.next();
		Student s2 = new Student(stuId2, stuName2);
		
		L1 = new ClassList(year, semester, subj, s1, s2);	
	}
	
	static public void printList(){
		if(L1 == null) {
			System.out.println("请先创建列表!");
			return;
		}
		System.out.println(L1.toString());
	}
}
