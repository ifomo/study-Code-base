package Vo;

public class courseGrade {
	private String id;
	private String courseName;
	private float grade;
	
	public courseGrade(String id, String courseName, float grade) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public String toString() {
		String info;
		info = id +"\t"+ courseName +"\t"+ grade;
		return info;
	}
}
