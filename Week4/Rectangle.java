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
		System.out.println("面积:" + this.width*this.length);
		//建议不要在类中直接输出，而是交给调用出输出！
	}
	
	public void Perimeter(){
		System.out.println("周长:" + 2*(width+length));
	}
}