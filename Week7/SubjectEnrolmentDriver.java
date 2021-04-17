package Week7_SubjectEnrolment_System;

public class SubjectEnrolmentDriver {
	private SubjectEnrolment sub;
	private Student stu[];
	private int count;
	
	public SubjectEnrolmentDriver(SubjectEnrolment sub) {
		this.stu = new Student[sub.getMaxStuNumber()];
		this.sub = sub;
		this.count = 0;
	}

	public int getCount() {
		return count;
	}
	
	public SubjectEnrolment getSub() {
		return this.sub;
	}

	public boolean add(Student temp) {
		if(temp == null)
			return false;
		if(count >= stu.length) {
			System.out.println("抱歉，该课程选课人数已满！");
			return false;
		}
//		System.out.println("学生数组长度"+stu.length); length方法返回的是数组总的长度大小！！！
		stu[count++] = temp;
		return true;
	}
	
	public boolean isFull() {
		if(count >= stu.length) 
			return true;
		else
			return false;
	}
	
	/*退选*/
	public boolean remove(String stuId) {
		int i = indexOf(stuId);
		if(i > -1) {  
			for(int j=i; j<count-1; j++) {
				stu[j] = stu[j+1];
			}
			stu[count-1] = null;  
			//数据前移后，注意将最后一个置为空，因为后面我的打印函数有一个判空语句
			count--;
			return true;
		}
		return false;
	}
	
	public int indexOf(String idNumber) {
		for(int i=0; i<stu.length && stu[i]!=null; i++) {
			if(stu[i].getId().equals(idNumber))
				return i;
		}
		return -1;
	}
	
	/*打印课程信息*/
	public void subPrint() {
		System.out.println(sub.toString() + "  " + "选课人数="+count);
	}
	
	/*打印选课名单*/
	public void stuPrint() {
		for(int i=0; i<stu.length && stu[i]!=null; i++) {
//		for(int i=0; i<count; i++) {
			System.out.println(stu[i].toString());
		}
	}
}
