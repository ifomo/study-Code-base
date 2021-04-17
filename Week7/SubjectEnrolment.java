package Week7_SubjectEnrolment_System;

public class SubjectEnrolment {
	private String subId;
	private String subName;
	private String semesterYear;
	private int maxStuNumber;
	
	public SubjectEnrolment(String subId, String subName, String semesterYear, int maxStuNumber) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.semesterYear = semesterYear;
		this.maxStuNumber = maxStuNumber;
	}

	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSemesterYear() {
		return semesterYear;
	}
	public void setSemesterYear(String semesterYear) {
		this.semesterYear = semesterYear;
	}
	public int getMaxStuNumber() {
		return maxStuNumber;
	}
	public void setMaxStuNumber(int maxStuNumber) {
		this.maxStuNumber = maxStuNumber;
	}

	public String toString() {
		String info;
		info = "课程号=" + this.subId + "  ";
		info += "课程名=" + this.subName + "  ";
		info += "开课学期=" + this.semesterYear + "  ";
		info += "开课人数=" + this.maxStuNumber;
		return info;
	}
}
