package Week_Four;

public class Dog {
	private String name;
	private String color;
	private int age;
	private String introduce;

	public Dog() {
		name = "胡望红";
		color = "yellow";
		age = 2;
		introduce = "666";
	}

	public Dog(String name, String color, int age, String introduce) {
		this.name = name;
		this.color = color;
		this.age = age;
		this.introduce = introduce;
	}

	public String outputInformation() {
		String information;
		information = "名字：" + this.name;
		information += "\n颜色：" + this.color;
		information += "\n年龄：" + this.age;
		information += "\n信息：" + this.introduce;

		return information;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIntroduce() {
		return this.introduce;
	}
}
