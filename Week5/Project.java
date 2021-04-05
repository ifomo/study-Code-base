package Week_Five;

public class Project {
	private String projectName;
	private float budget;
	private Employee emp1;
	private Employee emp2;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectName, float budget, Employee emp1, Employee emp2) {
		super();
		this.projectName = projectName;
		this.budget = budget;
		this.emp1 = emp1;
		this.emp2 = emp2;
	}
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public Employee getEmp1() {
		return emp1;
	}
	public void setEmp1(Employee emp1) {
		this.emp1 = emp1;
	}
	public Employee getEmp2() {
		return emp2;
	}
	public void setEmp2(Employee emp2) {
		this.emp2 = emp2;
	}

	public String toString() {
		String info;
		info = "工程：" + this.projectName;
		info += "  预算：" + this.budget;
		info += "\n员工信息:\n";
		info += "1." + emp1.toString() +"\n";
		info += "2." + emp2.toString();
		return info;
	}
}
