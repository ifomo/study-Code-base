package Week_Four;  //�������ΪĿ¼
 
import java.util.Scanner;

class Student{  //default��ȱʡ����Ĭ�ϵ����Σ���ͬһĿ¼�¿��У���֣�����public�����������⣬�ѵ�ֻ����ȡĿ¼�������ࣿ
    //����Ա������instance variable���;ֲ��������ֳ�ͻʱ������ʹ��this���ʳ�Ա������
	//��ʵ��Ա������instance method�����Ҳ������this���ʡ�
	
	/* ��Ա����һ��������private���Σ�������װ������
	 * �����ⲿ��Ҫ���ʡ��޸���ֻ��ͨ������public������ʵ�֣�
	 * һ�����Ƕ�������Ϊ setXxxx ��  getXxxx */
	private String name;
	private String phoneNumber;
	private int studentNumber;
	
	/*���췽�����޷���ֵ�������͡�����ͬ���������ء���ҪĿ����Ϊ�������Գ�ʼ��*/
	//û�в�����ȱʡ
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
		System.out.println("ѧ������:"+name +"  �绰:"+phoneNumber +"  ���:"+studentNumber);
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


/* ����������ص㿼�ǵ��ǽṹ��ܣ������ע���ǲ�ͬ��֮��Ĺ�ϵ��
 * �������ʵ���Ƿ�װ�����ģ�
 * UML
 * ���߻�ͼ��վ��https://www.freedgo.com/*/
