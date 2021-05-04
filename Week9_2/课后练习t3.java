package Lesson11;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 课后练习t3 {
	/*====================1.Input&Driver_Part====================*/
	public static void main(String[] args) {
		String content = "<html><head><title>欢迎访问武汉纺织大学主页</title></head></html>\r\n"
				+ "<body><img src=’1.jpg’/>\r\n"
				+ "<a href=’1.htm’>首页</a>\r\n"
				+ "<a href=’2.htm’>教务处</a>\r\n"
				+ "<a href=’3.htm’>数计学院</a>\r\n"
				+ "<img src=’2.jpg’/>\r\n"
				+ "<img src=’3.jpg’/>\r\n"
				+ "</body></html>";
//				+ "<title>哈哈，我是老A</title>";
		
		String regx = "<title>(.*?)</title>";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(content);
		/*循环查找出所有title标签内容*/
		while(m.find()) 
			System.out.println("网页标题：" + m.group(1));
		ArrayList<String> listPic = getPicture(content);
		ArrayList<Hyperlinks> listLink = getLinks(content);
		
		display(listPic, listLink);
	}
	
	/*====================2.Process_Part====================*/
	public static ArrayList<String> getPicture(String html) {
		ArrayList<String> listPic = new ArrayList<String>();
		Pattern p = Pattern.compile("(<img src=\\’)(.*?)(\\’/>)");
		Matcher m = p.matcher(html);
		while(m.find()) 
			listPic.add(m.group(2));
		return listPic;
	}
	public static ArrayList<Hyperlinks> getLinks(String html) {
		 ArrayList<Hyperlinks> listLink = new ArrayList<Hyperlinks>();
		 Pattern p = Pattern.compile("(<a href=\\’)(.*?)(\\’>)(.*?)(</a)");
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
		System.out.print("网页中共有" +listPic.size()+ "张图片，文件名为：");
		for(String s:listPic) {
			i++;
			if(i==listPic.size())
				System.out.println(s);
			else
				System.out.print(s + ",");
		}
		System.out.println("网页中包含" +listLink.size()+ "个超链接，超链接信息如下：");
		System.out.println("名称\t" + "地址");
		for(Hyperlinks h:listLink) 
			System.out.println(h.toString());
	}
}
