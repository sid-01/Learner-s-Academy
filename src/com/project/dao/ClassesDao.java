package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbConnection.DBConnection;

public class ClassesDao {
	
	public void insertClasses(String class_num) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "insert into class values(?)";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, class_num);
			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" class inserted successfully!");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void displayClasses() {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select * from class";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("class_num");
			System.out.println("-------");
			while (rs.next()) {
				System.out.println(rs.getString(1) );
				System.out.println();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public boolean classValidation(String class_id) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select class_id from class where class_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, class_id);

			int status = pstmt.executeUpdate();

			if (status > 0) {
				flag = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}


}
