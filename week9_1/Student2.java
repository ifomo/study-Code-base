package Vo;

public class Student2 {
	private String id;
	private String name;
	private String gender;
	private float aveageGrade;
	
	public Student2(String id, String name, String gender, float averageGrade) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.aveageGrade = averageGrade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getAveageGrade() {
		return aveageGrade;
	}
	public void setAveageGrade(float aveageGrade) {
		this.aveageGrade = aveageGrade;
	}

	public String toString() {
		String info;
		String ssa = String.format("%.1f", aveageGrade);
		info = id +"\t"+ name +"\t"+ gender +"\t"+ ssa;
		return info;
	}
}
