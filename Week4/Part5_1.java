package Week_Four;

public class Part5_1 {
	public static void main(String[] a) {
		Address a1 = new Address();
		Address a2 = new Address("����", "��ʢ��", "ŦԼ", "�����մ��", "852963");

		System.out.println(a1.getAddress());
		System.out.println(a2.getAddress());
		a2.setCountry("�й�");
		System.out.println(a2.getAddress());
	}
}
