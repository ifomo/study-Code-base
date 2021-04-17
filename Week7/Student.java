package Week7_SubjectEnrolment_System;

public class Student {
	private String stuId;
	private String stuName;
	
	public Student(String id, String name) {
		this.stuId = id;
		this.stuName = name;
	}

	public String getId() {
		return stuId;
	}
	public void setId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return stuName;
	}
	public void setName(String stuName) {
		this.stuName = stuName;
	}

	public String toString() {
		String info;
		info = "id=" + this.stuId + "  ";
		info += "name=" + this.stuName;
		return info;
	}
}
