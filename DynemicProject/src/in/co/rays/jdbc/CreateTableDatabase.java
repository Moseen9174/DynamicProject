package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableDatabase {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
			String q="Create table College(id int primary key , Name varchar(50), Address varchar(50), State varchar(50), City varchar(50) , MobaileNo varchar(15))";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Task Complete");
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
