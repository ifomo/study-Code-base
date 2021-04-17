package Week7_SubjectEnrolment_System;

import java.util.Scanner;

/*public class Part8_2 {
public static void main(String[] args) {
	Scanner cin = new Scanner(System.in); 
//	System.out.println("Enter subject data:");
	SubjectEnrolment sub1 = new SubjectEnrolment("3086", "操作系统", "2021第一学期", 3);
	SubjectEnrolmentDriver hut = new SubjectEnrolmentDriver(sub1);
	
	Student t1 = new Student("101", "saul");
	hut.add(t1);
	Student t2 = new Student("102", "mike");
	hut.add(t2);
	Student t3 = new Student("103", "kim");
	hut.add(t3);
	Student t4 = new Student("104", "gus");
	hut.add(t4);
	
	hut.subPrint();
	hut.stuPrint();
}
}*/

/*===============================================================*/
public class Part8_2 {
	public static Scanner cin = new Scanner(System.in);
	public static Driver2 cou = null;
	public static SubjectEnrolmentDriver hut = null;  //选课
	public static SubjectEnrolment sub1 = null;
	public static void main(String[] args) {
		int choice = mainMeun();
		while(choice!=5) {
			switch(choice){
			case 1: createCourse(); break;
			case 2: chooseCourse(); break;
			case 3: withdrawChoose(); break;
			case 4: printCourselist(); break;
			default: System.out.println("功能选项输入错误！"); break;
			}
			choice = mainMeun();
		}
		System.out.println("==========欢迎下次使用！==========");
	}
	
	public static int mainMeun() {
		System.out.println("==========Student course selection system==========");
		System.out.println("1.创建课程");
		System.out.println("2.选课");
		System.out.println("3.退选");
		System.out.println("4.打印名单");
		System.out.println("5.退出");
		System.out.println("请选择(1-5):");
		int choose = cin.nextInt();
		return choose;
	}
	
	/*1.创建课程*/
	public static void createCourse() {
		if(cou == null) {
			System.out.print("请先输入本学期一共开设课程数目:");
			int maxCourseNumber = cin.nextInt();
			cou = new Driver2(maxCourseNumber);
		}
		
		if(cou.isFull()) {
			System.out.println("抱歉，课程开设名额已满！");
			return;
		}
		
		System.out.print("输入课程号:");
		String subId = cin.next();
		System.out.print("输入课程名:");
		String subName = cin.next();
		System.out.print("输入课程学期:");
		String semesterYear = cin.next();
		System.out.print("输入开课最大人数:");
		int maxStuNumber = cin.nextInt();
		
		sub1 = new SubjectEnrolment(subId, subName, semesterYear, maxStuNumber);
		hut = new SubjectEnrolmentDriver(sub1);
		if(cou.addItem(hut))
			System.out.println("选课成功！");
		hut.subPrint();
	}
	
	/*2.选课*/
	public static void chooseCourse() {
		System.out.print("输入所选课程号码:");
		String courseId = cin.next();
		int i = cou.isExist(courseId);
		if(i==-1) {
			System.out.println("无该课程！");
			return;
		}
		hut = cou.getCourse(i);
		
		if(hut.isFull()) {
			System.out.println("抱歉，该课程选课人数已满！");
			return;
		}
		
		System.out.println("Enter student's id and name:");
		String idnum = cin.next();
		String name = cin.next();
		
		Student t1 = new Student(idnum, name);
		if(hut.add(t1))
			System.out.println("选课成功！");
		
		System.out.println("目前选课情况如下:");
		hut.subPrint();
		System.out.println("选课学生学号 姓名:");
		hut.stuPrint();
	}
	
	/*3.退选*/
	public static void withdrawChoose() {
		System.out.print("输入退选课程号码:");
		String courseId = cin.next();
		int i = cou.isExist(courseId);
		if(i==-1) {
			System.out.println("无该课程！");
			return;
		}
		hut = cou.getCourse(i);
		
		System.out.print("输入退选学生学号:");
		String studentId = cin.next();
		if(hut.remove(studentId)) {
			System.out.println("退选成功！");
		}
		else
			System.out.println("该学生未选此课程！");
	}
	
	public static void printCourselist() {
		cou.printAllcourse();
	}
}
