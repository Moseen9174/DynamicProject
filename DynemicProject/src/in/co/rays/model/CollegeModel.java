package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.UserBean;

public class CollegeModel {

	public int nextpk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("select max(id) from college");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public long add(CollegeBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO COLLEGE VALUES(?,?,?,?,?,?)");
		pstmt.setInt(1, nextpk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getAddress());
		pstmt.setString(4, bean.getState());
		pstmt.setString(5, bean.getCity());
		pstmt.setString(6, bean.getPhoneNo());
		int i = pstmt.executeUpdate();
		System.out.println("values inserted" + " " + i);
		return i;
	}

	public void update(CollegeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement(
				"update college set Name = ?, Address = ?, State = ?, City = ?, MobaileNo = ? where id = ?");
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getAddress());
		pstmt.setString(3, bean.getState());
		pstmt.setString(4, bean.getCity());
		pstmt.setString(5, bean.getPhoneNo());
		pstmt.setInt(6, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println("values update" + " " + i);
	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("delete from college where id = ?");
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		System.out.println("Deleted" + " " + i);
	}

	public CollegeBean FindByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("Select * from college where id=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		CollegeBean bean = null;
		while (rs.next()) {
			bean = new CollegeBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
		}
		return bean;
	}

	public List listSearch() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("Select * from college");
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			CollegeBean bean = new CollegeBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			list.add(bean);
		}
		return list;
	}
	
	public List search(CollegeBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		StringBuffer sql = new StringBuffer("select * from college where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append(" and Name like '" + bean.getName() + "%'");

			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println(sql.toString());
		PreparedStatement ps = con.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

		 bean = new CollegeBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			list.add(bean);

		}
		return list;

	}
}
