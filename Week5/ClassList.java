package Week_Five;

public class ClassList {
	private int year;
	private int semester;
	private Subject subj;
	private Student s1;
	private Student s2;
	
	public ClassList(){
		System.out.println("��ɶ�أ�");
	}
	public ClassList(int year, int semester, Subject subj, Student s1, Student s2) {
		this.year = year;
		this.semester = semester;
		this.subj = subj;
		this.s1 = s1;
		this.s2 = s2;
	}
	public Subject getSubj() {
		return subj;
	}
	public void setSubj(Subject subj) {
		this.subj = subj;
	}
	public Student getS1() {
		return s1;
	}
	public void setS1(Student s1) {
		this.s1 = s1;
	}
	public Student getS2() {
		return s2;
	}
	public void setS2(Student s2) {
		this.s2 = s2;
	}

	public String toString() {
		String info;
		info = this.year +"ѧ��  ��"+ this.semester +"ѧ��\n";
		info += this.subj.toString() +"\n";
		info += "ѧ��\t" + "����\n";
		info += this.s1.toString() + "\n";
		info += this.s2.toString();
		//����info�ַ������кܶಿ�ֹ��ɣ�������ɲ����������ܻ��У�
		return info;
	}
}
