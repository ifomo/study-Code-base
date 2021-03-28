package Week_Four;

public class Dog {
	private String name;
	private String color;
	private int age;
	private String introduce;

	public Dog() {
		name = "������";
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
		information = "���֣�" + this.name;
		information += "\n��ɫ��" + this.color;
		information += "\n���䣺" + this.age;
		information += "\n��Ϣ��" + this.introduce;

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
