package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dto.Category;

public class AdminModel {
	public static Connection start() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assets", "root", "kamal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public int loginCheck(String uname, String pass) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from adminlogin where username= ? and password= ?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int addCategory(Category cat) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("insert into category values(?,?,?)");
			ps.setString(1, cat.getUid());
			ps.setString(2, cat.getName());
			ps.setString(3, cat.getDescription());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> list = new ArrayList<Category>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category ct = new Category(rs.getString("uid"), rs.getString("name"), rs.getString("description"));
				list.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category getCategory(String uid) {
		Category ct = null;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from category where uid = ?");
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ct = new Category(rs.getString("uid"), rs.getString("name"), rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	public int updateCategory(Category cat) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("update category set name=?, description =? where uid= ? ");
			ps.setString(1, cat.getName());
			ps.setString(2, cat.getDescription());
			ps.setString(3, cat.getUid());

			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/*
	 * public int deleteStudent(String mobile) { int i = 0; Connection con = null;
	 * try { con = start(); PreparedStatement ps =
	 * con.prepareStatement("delete from student where mobile=?"); ps.setString(1,
	 * mobile); i = ps.executeUpdate(); } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * return i; }
	 */

}
