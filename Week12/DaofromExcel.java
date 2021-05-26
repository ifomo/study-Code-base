package Week12;

import java.io.File;
import java.util.ArrayList;

import Vo.Student2;
import Vo.cGradeResult;
import Vo.courseGrade;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DaofromExcel {
	/*====================1.Input_Part====================*/
	public static void importStudentFromExcel(ArrayList<Student2> list1, ArrayList<courseGrade> list2) {
		try{
			File file = new File("D:/Programming Files/Java_Program/Week_Nine/Student.xls");
			String temp[] = new String[3];
			Workbook wk = Workbook.getWorkbook(file);
			Sheet st1 = wk.getSheet(0);
			for(int i=1; i<st1.getRows(); i++) {  //行
				for(int j=0; j<st1.getColumns(); j++) {  //列
					Cell c = st1.getCell(j,i);
					temp[j] = c.getContents();
				}
				Student2 stu = new Student2(temp[0], temp[1], temp[2], 0.0f);
				list1.add(stu);
			}
			
			/*==========课程-分数信息放在了Sheets，就不用另读文件了==========*/
			Sheet st2 = wk.getSheet(1);
			for(int i=1; i<st2.getRows(); i++) {  
				for(int j=0; j<st2.getColumns(); j++) {  
					Cell c = st2.getCell(j,i);
					temp[j] = c.getContents();
				}
				courseGrade cou  = new courseGrade(temp[0], temp[1], Float.valueOf(temp[2]));
				list2.add(cou);
			}
			wk.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*====================2.Process_Part====================*/
	public static ArrayList<Student2> calculateStudent(ArrayList<Student2> list1, ArrayList<courseGrade> list2) {
		float grade;
		int i;
		for (Student2 stu : list1) {
			grade = 0.0f;
			i = 0;
			for (courseGrade cou : list2) {
				if(cou.getId().equals(stu.getId())) {  
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
	
	public static void saveAsExcel(ArrayList<Student2> list1, ArrayList<cGradeResult> list2) {
		try {
			File file = new File("D:/Programming Files/Java_Program"
					+ "/Week_Nine/src/Week12/result2.xls");
			String temp[] = new String[4];
			WritableWorkbook wk = Workbook.createWorkbook(file);
			WritableSheet sheet1 = wk.createSheet("Sheet1", 0);
			sheet1.addCell(new Label(0, 0, "输出结果："));
			sheet1.addCell(new Label(0, 1, "按学生统计："));
			for(int i=2; i<6; i++) {
				Student2 stu = list1.get(i-2);
				temp[0] = stu.getId();
				temp[1] = stu.getName();
				temp[2] = stu.getGender();
				temp[3] = String.valueOf(stu.getAveageGrade());
				for(int j=0; j<4; j++) {
					sheet1.addCell(new Label(j, i, temp[j]));
				}
			}
			
			sheet1.addCell(new Label(0, 6, "按课程统计："));
			for(int i=7; i<10; i++) {
				cGradeResult res = list2.get(i-7);
				temp[0] = res.getCourseName();
				temp[1] = String.valueOf(res.getAveageGrade());
				for(int j=0; j<2; j++) {
					sheet1.addCell(new Label(j, i, temp[j]));
				}
			}
			wk.write();  //切记该语句，否者表格无法成功创建！
			wk.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*====================4.Test_Part====================*/
	public static void main(String args[]) {
		ArrayList<Student2> listStudent = new ArrayList<Student2>();
		ArrayList<courseGrade> listCourse = new ArrayList<courseGrade>();
		importStudentFromExcel(listStudent, listCourse);
		
		listStudent = calculateStudent(listStudent, listCourse);
		ArrayList<cGradeResult> result = calculateCourse(listCourse);
		
		System.out.println("输出结果：");
		print(listStudent, result);
		saveAsExcel(listStudent, result);
	}
}
