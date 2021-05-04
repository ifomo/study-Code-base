package Lesson11;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class �κ���ϰt3 {
	/*====================1.Input&Driver_Part====================*/
	public static void main(String[] args) {
		String content = "<html><head><title>��ӭ�����人��֯��ѧ��ҳ</title></head></html>\r\n"
				+ "<body><img src=��1.jpg��/>\r\n"
				+ "<a href=��1.htm��>��ҳ</a>\r\n"
				+ "<a href=��2.htm��>����</a>\r\n"
				+ "<a href=��3.htm��>����ѧԺ</a>\r\n"
				+ "<img src=��2.jpg��/>\r\n"
				+ "<img src=��3.jpg��/>\r\n"
				+ "</body></html>";
//				+ "<title>������������A</title>";
		
		String regx = "<title>(.*?)</title>";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(content);
		/*ѭ�����ҳ�����title��ǩ����*/
		while(m.find()) 
			System.out.println("��ҳ���⣺" + m.group(1));
		ArrayList<String> listPic = getPicture(content);
		ArrayList<Hyperlinks> listLink = getLinks(content);
		
		display(listPic, listLink);
	}
	
	/*====================2.Process_Part====================*/
	public static ArrayList<String> getPicture(String html) {
		ArrayList<String> listPic = new ArrayList<String>();
		Pattern p = Pattern.compile("(<img src=\\��)(.*?)(\\��/>)");
		Matcher m = p.matcher(html);
		while(m.find()) 
			listPic.add(m.group(2));
		return listPic;
	}
	public static ArrayList<Hyperlinks> getLinks(String html) {
		 ArrayList<Hyperlinks> listLink = new ArrayList<Hyperlinks>();
		 Pattern p = Pattern.compile("(<a href=\\��)(.*?)(\\��>)(.*?)(</a)");
		 Matcher m = p.matcher(html);
		 while(m.find()) {
			 Hyperlinks h1 = new Hyperlinks(m.group(4), m.group(2));
			 listLink.add(h1);
		 }
		 return listLink;
	}
	
	/*====================3.Output_Part====================*/
	public static void display(ArrayList<String> listPic, ArrayList<Hyperlinks> listLink) {
		int i=0;
		System.out.print("��ҳ�й���" +listPic.size()+ "��ͼƬ���ļ���Ϊ��");
		for(String s:listPic) {
			i++;
			if(i==listPic.size())
				System.out.println(s);
			else
				System.out.print(s + ",");
		}
		System.out.println("��ҳ�а���" +listLink.size()+ "�������ӣ���������Ϣ���£�");
		System.out.println("����\t" + "��ַ");
		for(Hyperlinks h:listLink) 
			System.out.println(h.toString());
	}
}
