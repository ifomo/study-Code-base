package Lesson11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ¿ÎºóÁ·Ï°t4 {
	public static void main(String[] args) {
		String html = "<font face=¡¯Arial Serif¡¯ size=¡¯10px¡¯ color=¡¯red¡¯ />";
//		String html = "<font size=\"3\" color=\"red\">This is some text!</font>";
		Pattern p1 = Pattern.compile("<\s*font\s*([^>]*)\s*/>", Pattern.CASE_INSENSITIVE);
		Pattern p2 = Pattern.compile("([a-z]+)\s*=\s*\\¡¯([^\\¡¯]+)\\¡¯", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(html);
		Matcher m2 = p2.matcher(html);
		
		if(m1.find())
			System.out.println(m1.group(1));
		while(m2.find())
			System.out.println(m2.group(1) +":"+ m2.group(2));
	}
}
