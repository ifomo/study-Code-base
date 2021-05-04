package Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import Vo.Student2;
import Vo.cGradeResult;
import Vo.courseGrade;

public class 第10次课_课后习题Dao {
	public static Scanner cin = new Scanner(System.in); 
	
	/*====================1.Input_Part====================*/
	public static ArrayList<Student2> inputFromKeyBoard1() {
		ArrayList<Student2> listStu = new ArrayList<Student2>(); 
		System.out.println("请输入学生基本信息：");
		String sData = cin.nextLine();
		while(!sData.equals("end")) {
			String[] d = sData.split(",|，");
			Student2 t = new Student2(d[0], d[1], d[2], 0.0f);
			listStu.add(t);
			sData = cin.nextLine();
		}
		return listStu;
	}
	
	public static ArrayList<courseGrade> inputFromKeyBoard2() {
		ArrayList<courseGrade> listStuGrade = new ArrayList<courseGrade>(); 
		System.out.println("请输入学生成绩：");
		String sGrade = cin.nextLine();
		while(!sGrade.equals("end")) {
			String[] d = sGrade.split(",|，");
			courseGrade t = new courseGrade(d[0], d[1], Float.parseFloat(d[2]));
			listStuGrade.add(t);
			sGrade = cin.nextLine();
		}
		return listStuGrade;
	}
	
	public static ArrayList<courseGrade> inputFromFile(File file) {
		ArrayList<courseGrade> listStuGrade = new ArrayList<courseGrade>(); 
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
//			while((s = br.readLine())!="end") {  // is that can???
			/*直接用'='符号比较，中间有报警，但结果还是正确显示出来了。
			 *保险起见，用equals()*/
			s = br.readLine();
			while(!s.equals("end")) {
				String d[] = s.split(",|，");
				courseGrade t = new courseGrade(d[0], d[1], Float.parseFloat(d[2]));
				listStuGrade.add(t);
				s = br.readLine();
			}
			br.close();    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listStuGrade;
	}
	
	/*====================2.Process_Part====================*/
	public static ArrayList<Student2> calculateStudent(ArrayList<Student2> list1, ArrayList<courseGrade> list2) {
		Student2 t1;
		float aGrade =0.0f;
		for(int i=0; i<list1.size(); i++) {
			t1 = list1.get(i);  //另外构建学生列表太麻烦，直接在传入参数基础上修改
			aGrade = averageGrade(t1.getId(), list2);
			t1.setAveageGrade(aGrade);
			list1.set(i, t1);
		}
		return list1;
	}
	public static ArrayList<cGradeResult> calculateCourse(ArrayList<courseGrade> list) {
		ArrayList<cGradeResult> listCou = new ArrayList<cGradeResult>();
		courseGrade t;
		float aGrade =0.0f;
		for(int i=0; i<list.size(); i++) {
			t = list.get(i);
			if(!isExist(t.getCourseName(), listCou)) {
				aGrade = averageGrade(t.getCourseName(), list);
				cGradeResult c = new cGradeResult(t.getCourseName(), aGrade);
				listCou.add(c);
			}	
		}
		return listCou;
	}
	
	public static float averageGrade(String index, ArrayList<courseGrade> list) {
		courseGrade t;
		int j = 0;
		float aGrade = 0.0f;
		
		for(int i=0; i<list.size(); i++) {
			t = list.get(i);
			if(t.getId().equals(index) || t.getCourseName().equals(index)) {
				aGrade += t.getGrade();
				j++;
			}
		}
		aGrade = aGrade/j;
		return aGrade;
	}
	public static boolean isExist(String index, ArrayList<cGradeResult> list) {
		cGradeResult t;
		for(int i=0; i<list.size(); i++) {
			t = list.get(i);
			if(t.getCourseName().equals(index))
				return true;
		}
		return false;
	}
	
	/*====================3.Output_Part====================*/
	public static void display(ArrayList<Student2> listStu, ArrayList<cGradeResult> listCou) {
		System.out.println("按学生统计：");
		System.out.println("学号" +"\t"+ "姓名" +"\t"+ "性别" +"\t"+ "平均分");
		for(int i=0; i<listStu.size(); i++) {
			System.out.println(listStu.get(i).toString());
		}
		
		System.out.println("按课程统计：");
		System.out.println("课程" +"\t"+ "平均分");
		for(int i=0; i<listCou.size(); i++) {
			System.out.println(listCou.get(i).toString());
		}
	}
	
	/*====================Test====================*/
	/*public static void main(String[] args) {
		File file = new File("D:/Programming Files/Java_Program/Week_Nine/src/Driver/inputData.txt");
		ArrayList<Student2> listStu = inputFromKeyBoard1();
//		ArrayList<courseGrade> listStuGrade = inputFromKeyBoard2();
		ArrayList<courseGrade> listStuGrade = inputFromFile(file);
		
		listStu = calculateStudent(listStu, listStuGrade);
		display(listStu);
	}*/
}
