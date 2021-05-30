package Week13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class xiti13_1 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		//从文本文档中读出数据，再写入数据库中：
		try {
			//int iCount = 0;ַ
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/vdadh?useUicode=true&characterEncoding=utf-8&useSSL=false";  
			String userName = "root";
			String passWord = "110708";
			Connection con = DriverManager.getConnection(url, userName, passWord);
			/*String sql = "insert into t_student2(id,name,gender,birth,score) values(?,?,?,?,?)"; 
			
			File file = new File("D:/Programming Files/Java_Program/Week_Nine"
					+ "/src/Week13/f_student.txt");  //水库
			FileReader fr = new FileReader(file);  //水管
			BufferedReader br = new BufferedReader(fr);  //水龙头
			String line = "";
			while((line=br.readLine())!=null) {
				PreparedStatement pst = con.prepareStatement(sql);
				String end[] = line.split(",|，");
				pst.setString(1, end[0]);
				pst.setString(2, end[1]);
				pst.setString(3, end[2]);
				pst.setString(4, end[3]);
				pst.setFloat(5, Float.valueOf(end[4]));
				iCount += pst.executeUpdate();
				pst.close();
			}
			System.out.println(iCount+"条记录被改变！");*/
			
			System.out.println("请输入查询学号：");
			String searchId = cin.next();
			String sql2 = "Select * from t_student2 where id="+"'"+ searchId +"'";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			ResultSet rs = pst2.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				String score = rs.getString("score");
				System.out.println(id+" "+name+" "+gender+" "+birth+" "+score);
			}
			pst2.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
