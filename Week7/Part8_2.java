package Week7_SubjectEnrolment_System;

import java.util.Scanner;

/*public class Part8_2 {
public static void main(String[] args) {
	Scanner cin = new Scanner(System.in); 
//	System.out.println("Enter subject data:");
	SubjectEnrolment sub1 = new SubjectEnrolment("3086", "����ϵͳ", "2021��һѧ��", 3);
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
	public static SubjectEnrolmentDriver hut = null;  //ѡ��
	public static SubjectEnrolment sub1 = null;
	public static void main(String[] args) {
		int choice = mainMeun();
		while(choice!=5) {
			switch(choice){
			case 1: createCourse(); break;
			case 2: chooseCourse(); break;
			case 3: withdrawChoose(); break;
			case 4: printCourselist(); break;
			default: System.out.println("����ѡ���������"); break;
			}
			choice = mainMeun();
		}
		System.out.println("==========��ӭ�´�ʹ�ã�==========");
	}
	
	public static int mainMeun() {
		System.out.println("==========Student course selection system==========");
		System.out.println("1.�����γ�");
		System.out.println("2.ѡ��");
		System.out.println("3.��ѡ");
		System.out.println("4.��ӡ����");
		System.out.println("5.�˳�");
		System.out.println("��ѡ��(1-5):");
		int choose = cin.nextInt();
		return choose;
	}
	
	/*1.�����γ�*/
	public static void createCourse() {
		if(cou == null) {
			System.out.print("�������뱾ѧ��һ������γ���Ŀ:");
			int maxCourseNumber = cin.nextInt();
			cou = new Driver2(maxCourseNumber);
		}
		
		if(cou.isFull()) {
			System.out.println("��Ǹ���γ̿�������������");
			return;
		}
		
		System.out.print("����γ̺�:");
		String subId = cin.next();
		System.out.print("����γ���:");
		String subName = cin.next();
		System.out.print("����γ�ѧ��:");
		String semesterYear = cin.next();
		System.out.print("���뿪���������:");
		int maxStuNumber = cin.nextInt();
		
		sub1 = new SubjectEnrolment(subId, subName, semesterYear, maxStuNumber);
		hut = new SubjectEnrolmentDriver(sub1);
		if(cou.addItem(hut))
			System.out.println("ѡ�γɹ���");
		hut.subPrint();
	}
	
	/*2.ѡ��*/
	public static void chooseCourse() {
		System.out.print("������ѡ�γ̺���:");
		String courseId = cin.next();
		int i = cou.isExist(courseId);
		if(i==-1) {
			System.out.println("�޸ÿγ̣�");
			return;
		}
		hut = cou.getCourse(i);
		
		if(hut.isFull()) {
			System.out.println("��Ǹ���ÿγ�ѡ������������");
			return;
		}
		
		System.out.println("Enter student's id and name:");
		String idnum = cin.next();
		String name = cin.next();
		
		Student t1 = new Student(idnum, name);
		if(hut.add(t1))
			System.out.println("ѡ�γɹ���");
		
		System.out.println("Ŀǰѡ���������:");
		hut.subPrint();
		System.out.println("ѡ��ѧ��ѧ�� ����:");
		hut.stuPrint();
	}
	
	/*3.��ѡ*/
	public static void withdrawChoose() {
		System.out.print("������ѡ�γ̺���:");
		String courseId = cin.next();
		int i = cou.isExist(courseId);
		if(i==-1) {
			System.out.println("�޸ÿγ̣�");
			return;
		}
		hut = cou.getCourse(i);
		
		System.out.print("������ѡѧ��ѧ��:");
		String studentId = cin.next();
		if(hut.remove(studentId)) {
			System.out.println("��ѡ�ɹ���");
		}
		else
			System.out.println("��ѧ��δѡ�˿γ̣�");
	}
	
	public static void printCourselist() {
		cou.printAllcourse();
	}
}
