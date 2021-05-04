package Driver;

import java.io.File;
import java.util.ArrayList;

import Vo.Student2;
import Vo.cGradeResult;
import Vo.courseGrade;
import Dao.第10次课_课后习题Dao;

public class 第10次课_课后习题Driver {
	public static void main(String[] args) {
		/*==========1.Input==========*/
		File file = new File("D:/Programming Files/Java_Program/Week_Nine/src/Driver/inputData.txt");
		ArrayList<Student2> listStu = 第10次课_课后习题Dao.inputFromKeyBoard1();
		ArrayList<courseGrade> listStuGrade = 第10次课_课后习题Dao.inputFromFile(file);
		
		/*==========2.Process==========*/
		listStu = 第10次课_课后习题Dao.calculateStudent(listStu, listStuGrade);
		ArrayList<cGradeResult> listCou = 第10次课_课后习题Dao.calculateCourse(listStuGrade);
		
		/*==========3.Output==========*/
		第10次课_课后习题Dao.display(listStu, listCou);
	}
}
