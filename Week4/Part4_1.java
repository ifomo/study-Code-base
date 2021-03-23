package Week_Four;  //可以理解为目录
 
import java.util.Scanner;

class Student{  //default（缺省），默认的修饰，在同一目录下可行！奇怪：加上public反而还有问题，难道只能另取目录创建该类？
    //当成员变量（instance variable）和局部变量名字冲突时，我们使用this访问成员变量。
	//其实成员方法（instance method）因该也可以用this访问。
	
	/* 成员变量一般我们用private修饰，把它封装起来；
	 * 所以外部想要访问、修改它只能通过构造public方法来实现；
	 * 一般我们都是命名为 setXxxx 或  getXxxx */
	private String name;
	private String phoneNumber;
	private int studentNumber;
	
	/*构造方法：无返回值、无类型、和类同名、可重载。主要目的是为类中属性初始化*/
	//没有参数，缺省
	/*public Student(){  
		
	}*/
	
	public Student(String name, String phoneNumber, int studentNumber){
		this.name = name;
		//this.setName(name);
		this.phoneNumber = phoneNumber;
		this.studentNumber = studentNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void displayStudent(){
		System.out.println("学生姓名:"+name +"  电话:"+phoneNumber +"  编号:"+studentNumber);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", phoneNumber=" + phoneNumber + ", studentNumber=" + studentNumber + "]";
	}
}

public class Part4_1 {
	public static void main(String[] a){
		Scanner cin = new Scanner(System.in);
		Student s1 = new Student("Jack", "15271662256", 01);
		s1.displayStudent();
		
		s1.setName("Tom");
		s1.displayStudent();
		System.out.println(s1.toString());
		
		//int haha = cin.nextInt();
		//System.out.println("%4.d", haha);
	}
}


/* 面向对象编程重点考虑的是结构框架，整体关注的是不同类之间的关系；
 * 具体类的实现是封装起来的；
 * UML
 * 在线画图网站：https://www.freedgo.com/*/
