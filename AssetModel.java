package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dto.Asset;
import com.dto.Employee;

public class AssetModel {
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

	public int addAsset(Asset ast) {
		int i = 0;
		Connection con = null;
		try {
			con = start();

			PreparedStatement ps = con.prepareStatement("insert into asset values(?,?,?,?,?)");
			ps.setString(1, ast.getName());
			ps.setString(2, ast.getPurDate());
			ps.setString(3, ast.getConNote());
			ps.setString(4, ast.getCategory());
			ps.setString(5, ast.getStatus());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Asset> getAllAssets() {
		ArrayList<Asset> list = new ArrayList<Asset>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from asset");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Asset ast = new Asset(rs.getString("name"), rs.getString("purchasedate"),
						rs.getString("conditionnotes"), rs.getString("category"), rs.getString("assignmentstatus"));
				list.add(ast);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Asset getAsset(String name) {
		Asset ast = null;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from asset where name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ast = new Asset(rs.getString("name"), rs.getString("purchasedate"), rs.getString("conditionnotes"),
						rs.getString("category"), rs.getString("assignmentstatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ast;
	}

	public int updateAsset(Asset ast) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement(
					"update asset set name=?, purchasedate=?,  conditionnotes=?, category = ?, assignmentstatus = ? where name= ? ");
			ps.setString(1, ast.getName());
			ps.setString(2, ast.getPurDate());
			ps.setString(3, ast.getConNote());
			ps.setString(4, ast.getCategory());
			ps.setString(5, ast.getStatus());
			ps.setString(6, ast.getName());

			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Asset> getAllCategories() {
		ArrayList<Asset> list = new ArrayList<Asset>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from asset");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Asset ast = new Asset(rs.getString("name"), rs.getString("purchasedate"),
						rs.getString("conditionnotes"), rs.getString("category"), rs.getString("assignmentstatus"));
				list.add(ast);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getAssignmentStatus(String name) {
		Connection con = null;
		String status = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from asset where name = ?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString("assignmentstatus");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deleteAsset(String name) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("delete from asset where name= ? ");
			ps.setString(1, name);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Employee> getEmployeeNames() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("select * from employee");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee(rs.getString("uid"), rs.getString("name"), rs.getString("designation"));
				list.add(em);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeAssetStatus(String name) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement ps = con.prepareStatement("update asset set assignmentstatus = ? where name= ? ");
			ps.setString(1, "assigned");
			ps.setString(2, name);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
