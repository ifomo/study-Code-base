package Week_Four;

public class Rectangle {
	private float width, length;
	
	public Rectangle(){
		this.width = 1.0f;
		this.length = 1.0f;
	}
	
	public Rectangle(float width, float length){
		this.width = width;
		this.length = length;
	}
	
	public void Area(){
		System.out.println("���:" + this.width*this.length);
		//���鲻Ҫ������ֱ����������ǽ������ó������
	}
	
	public void Perimeter(){
		System.out.println("�ܳ�:" + 2*(width+length));
	}
}