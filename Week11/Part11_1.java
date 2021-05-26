package Driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part11_1 {
	public static void main(String[] args) {
		try {
			// 读取文件
			File afile = new File("D:/Programming Files/Java_Program/Week_Nine/src/Driver/运算题目.txt");
			FileReader fr = new FileReader(afile);
			BufferedReader br = new BufferedReader(fr);

			// 写入文件
			File bfile = new File("./运算结果.txt");
			FileWriter fw = new FileWriter(bfile);
			PrintWriter pw = new PrintWriter(fw);

			String express = null;
			while ((express = br.readLine()) != null) {
//				System.out.println(express);
				String regex = "((add)|(sub)|(max)|(min)|(doubleMe)|(muti)|(div))\\(\\d{1,}(,\\d{1,})?\\)";

				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(express);

				String result = "";
				String express2 = express;
				while (m.find()) {
					String base = m.group();
					result = cal(base);
					base = base.replaceAll("\\(", "\\\\(");
					base = base.replaceAll("\\)", "\\\\)");
					express2 = express2.replaceAll(base, result);
					m = p.matcher(express2);
				}
				pw.println(express + "=" + result);
//				System.out.println(express + "=" + result);
			}
			br.close();
			fr.close();
			pw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String cal(String s) {
		String result = "";
		int pos = s.indexOf("(");
		int pos3 = s.indexOf(")");
		String a = s.substring(0, pos);

		if (a.equals("doubleMe")) {
			int num = Integer.parseInt(s.substring(pos + 1, pos3));
			result = String.valueOf(num * 2);
		} else {
			int pos2 = s.indexOf(",");
			int a1, a2;
			a1 = Integer.parseInt(s.substring(pos + 1, pos2));
			a2 = Integer.parseInt(s.substring(pos2 + 1, pos3));

			switch (a) {
			case "add":
				result = String.valueOf(a1 + a2);
				break;
			case "sub":
				result = String.valueOf(a1 - a2);
				break;
			case "max":
				result = String.valueOf(a1 > a2 ? a1 : a2);
				break;
			case "min":
				result = String.valueOf(a1 > a2 ? a2 : a1);
				break;
			case "muti":
				result = String.valueOf(a1 * a2);
				break;
			case "div":
				result = String.valueOf(a1 / a2);
				break;
			}
		}
		return result;
	}
}
