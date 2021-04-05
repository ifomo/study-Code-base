package Week_Five;

public class Student {
	private String studentID;
	private String studentName;
	
	public Student(){
		studentID = "000";
		studentName = "ĞÕÃû";
	}
	public Student(String studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String toString() {
		return (this.studentID +"\t" + this.studentName);
	}
}

