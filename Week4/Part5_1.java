package Week_Four;

//用到Address.java文件构造的Address类
public class Part5_1 {
	public static void main(String[] a) {
		Address a1 = new Address();
		Address a2 = new Address("英国", "湖北省", "黄石市", "团城市路", "654321");

		System.out.println(a1.getAddress());
		System.out.println(a2.getAddress());
		a2.setCountry("中国");
		System.out.println(a2.getAddress());
	}
}
