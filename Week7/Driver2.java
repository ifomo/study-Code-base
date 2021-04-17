package Week7_SubjectEnrolment_System;

public class Driver2 {
	private SubjectEnrolmentDriver course[];
	private int courseCount;
	
	public Driver2(int maxSize) {
		this.course = new SubjectEnrolmentDriver[maxSize];
		this.courseCount = 0;
	}
	
	public int getCount( ) {
		return this.courseCount;
	}
	
	public SubjectEnrolmentDriver getCourse(int i) {
		return course[i];
	}
	
	public boolean addItem(SubjectEnrolmentDriver temp) {
		if(temp == null)
			return false;
		if(courseCount >= course.length) {
			return false;
		}
		course[courseCount++] = temp;
		return true;
	}
	
	/*在类中新构建函数判断开设课程数目是否已满，因为在主函数中创建课程时；
	* 等到各种课程数据输入完后，再执行addItem函数，同时判断满否，有点麻烦了；
	* 因该直接创建时，一开始就告诉你，课程满了！选课添加学生同理。*/
	public boolean isFull() {
		if(courseCount >= course.length)
			return true;
		else
			return false;
	}
	
	//查找课程号，结果不为-1，说明找到，数据前移
	public boolean remove(String subId) {
		int i = isExist(subId);
		if(i > -1) {
			for(int j=i; j<courseCount-1; j++) {
				course[j] = course[j+1];
			}
			course[courseCount-1] = null;
			courseCount--;
			return true;
		}
		return false;
	}
	
	//按理说，因该是先输出课程号，我们再来查找删除
	public int isExist(String subId) {
		for(int i=0; i<courseCount; i++) {
			if(subId.equals(course[i].getSub().getSubId())) {
				return i;
			}
		}
		return -1;
	}
	
	public void printAllcourse() {
		for(int i=0; i<courseCount; i++) {
			System.out.println("===================================");
			course[i].subPrint();
			course[i].stuPrint();
			System.out.println();
		}
	}
}
