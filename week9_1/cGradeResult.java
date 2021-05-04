package Vo;

public class cGradeResult {
	private String courseName;
	private float aveageGrade;
	
	public cGradeResult(String courseName, float aveageGrade) {
		this.courseName = courseName;
		this.aveageGrade = aveageGrade;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
		info = courseName +"\t"+ ssa;
		return info;
	}
}
