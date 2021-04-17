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
			System.out.println("��Ǹ���ÿγ�ѡ������������");
			return false;
		}
//		System.out.println("ѧ�����鳤��"+stu.length); length�������ص��������ܵĳ��ȴ�С������
		stu[count++] = temp;
		return true;
	}
	
	public boolean isFull() {
		if(count >= stu.length) 
			return true;
		else
			return false;
	}
	
	/*��ѡ*/
	public boolean remove(String stuId) {
		int i = indexOf(stuId);
		if(i > -1) {  
			for(int j=i; j<count-1; j++) {
				stu[j] = stu[j+1];
			}
			stu[count-1] = null;  
			//����ǰ�ƺ�ע�⽫���һ����Ϊ�գ���Ϊ�����ҵĴ�ӡ������һ���п����
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
	
	/*��ӡ�γ���Ϣ*/
	public void subPrint() {
		System.out.println(sub.toString() + "  " + "ѡ������="+count);
	}
	
	/*��ӡѡ������*/
	public void stuPrint() {
		for(int i=0; i<stu.length && stu[i]!=null; i++) {
//		for(int i=0; i<count; i++) {
			System.out.println(stu[i].toString());
		}
	}
}
