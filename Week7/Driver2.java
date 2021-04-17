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
	
	/*�������¹��������жϿ���γ���Ŀ�Ƿ���������Ϊ���������д����γ�ʱ��
	* �ȵ����ֿγ��������������ִ��addItem������ͬʱ�ж������е��鷳�ˣ�
	* ���ֱ�Ӵ���ʱ��һ��ʼ�͸����㣬�γ����ˣ�ѡ�����ѧ��ͬ��*/
	public boolean isFull() {
		if(courseCount >= course.length)
			return true;
		else
			return false;
	}
	
	//���ҿγ̺ţ������Ϊ-1��˵���ҵ�������ǰ��
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
	
	//����˵�������������γ̺ţ�������������ɾ��
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
