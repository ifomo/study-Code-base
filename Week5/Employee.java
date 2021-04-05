package Week_Five;

public class Employee {
	private String id;
	private String name;
	private String department;
	private float salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String id, String name, String department, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void updateSalary(float upRate) {  //Ôö³¤Ð½Ë®
		this.salary += this.salary * (upRate/100);
	}
	
	public String toString() {
		String info;
		info = "id£º" + this.id;
		info += "  name " + this.name;
		info += "  department£º" + this.department;
		info += "  salary£º" + this.salary;
		return info;
	}
}
