package Week12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Vo.Student2;
import Vo.cGradeResult;
import Vo.courseGrade;

public class DaofromTxt {
	/*====================1.Input_Part====================*/
	public static ArrayList<Student2> importStudentFromTxt() {
		ArrayList<Student2> listStu = new ArrayList<Student2>();
		File file = new File("D:/Programming Files/Java_Program"
				+ "/Week_Nine/src/Week12/stuData.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				String end[] = line.split(",|，");
				Student2 temp = new Student2(end[0], end[1], end[2], 0.0f);
				listStu.add(temp);
//				System.out.print(end[0]+"|");
//				System.out.print(end[0].length()+"\n");  
				/*通过查看长度，我发现第一行的001带上了空格；
				 *故它长度为4，自然是和后面的001比较时出错！！！
				 *不过为什么会这样，又为什么其他行无问题，为什么下面课程读入时，也没问题？*/
			}
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();  //异常输出
		}
		return listStu;
	}
	
	public static ArrayList<courseGrade> importCourseFromTxt() {
		ArrayList<courseGrade> listCou = new ArrayList<courseGrade>();
		File file = new File("D:/Programming Files/Java_Program"
				+ "/Week_Nine/src/Week12/courseGradeData.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				String end[] = line.split(",|，");
				courseGrade t = new courseGrade(end[0], end[1], Float.valueOf(end[2]));
				listCou.add(t);
			}
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return listCou;
	}
	
	/*====================2.Process_Part====================*/
	public static ArrayList<Student2> calculateStudent(ArrayList<Student2> list1, ArrayList<courseGrade> list2) {
		float grade;
		int i;
		for (Student2 stu : list1) {
			grade = 0.0f;
			i = 0;
			for (courseGrade cou : list2) {
				if(cou.getId().equals(stu.getId())) {  //为什么学号001，判断不相等？
					i++;
					grade += cou.getGrade();
				}
			}
			stu.setAveageGrade(grade/i);
		}
		return list1;
	}
	
	public static ArrayList<cGradeResult> calculateCourse(ArrayList<courseGrade> list) {
		ArrayList<cGradeResult> result = new ArrayList<cGradeResult>();
		courseGrade t;
		float aGrade =0.0f;
		for(int i=0; i<list.size(); i++) {
			t = list.get(i);
			if(!isExist(t.getCourseName(), result)) {
				aGrade = averageGrade(t.getCourseName(), list);
				cGradeResult c = new cGradeResult(t.getCourseName(), aGrade);
				result.add(c);
			}	
		}
		return result;
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
	public static void print(ArrayList<Student2> list1, ArrayList<cGradeResult> list2) {
		System.out.println("按学生统计：");
		for (Student2 t : list1) {
			System.out.println(t.toString());
		}
		
		System.out.println("按课程统计：");
		for (cGradeResult t : list2) {
			System.out.println(t.toString());
		}
	}
	
	public static void saveAsTxt(ArrayList<Student2> list1, ArrayList<cGradeResult> list2) {
		try {
			File oFl = new File("D:/Programming Files/Java_Program"
					+ "/Week_Nine/src/Week12/result.txt");
			FileWriter fwt = new FileWriter(oFl);
			PrintWriter pwt = new PrintWriter(fwt);
			
			pwt.println("按学生统计：");
			for (Student2 t : list1) 
				pwt.println(t.toString());
			System.out.println("按课程统计：");
			for (cGradeResult t : list2) 
				pwt.println(t.toString());
			
			pwt.close();
			fwt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*====================4.Test_Part====================*/
	public static void main(String args[]) {
		ArrayList<Student2> listStudent = importStudentFromTxt();
		ArrayList<courseGrade> listCourse = importCourseFromTxt();
		
		listStudent = calculateStudent(listStudent, listCourse);
		ArrayList<cGradeResult> result = calculateCourse(listCourse);
		
		System.out.println("输出结果：");
		print(listStudent, result);
		saveAsTxt(listStudent, result);
	}
}
