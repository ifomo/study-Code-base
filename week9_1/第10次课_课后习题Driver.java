package Driver;

import java.io.File;
import java.util.ArrayList;

import Vo.Student2;
import Vo.cGradeResult;
import Vo.courseGrade;
import Dao.��10�ο�_�κ�ϰ��Dao;

public class ��10�ο�_�κ�ϰ��Driver {
	public static void main(String[] args) {
		/*==========1.Input==========*/
		File file = new File("D:/Programming Files/Java_Program/Week_Nine/src/Driver/inputData.txt");
		ArrayList<Student2> listStu = ��10�ο�_�κ�ϰ��Dao.inputFromKeyBoard1();
		ArrayList<courseGrade> listStuGrade = ��10�ο�_�κ�ϰ��Dao.inputFromFile(file);
		
		/*==========2.Process==========*/
		listStu = ��10�ο�_�κ�ϰ��Dao.calculateStudent(listStu, listStuGrade);
		ArrayList<cGradeResult> listCou = ��10�ο�_�κ�ϰ��Dao.calculateCourse(listStuGrade);
		
		/*==========3.Output==========*/
		��10�ο�_�κ�ϰ��Dao.display(listStu, listCou);
	}
}
