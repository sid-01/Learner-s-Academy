package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbConnection.DBConnection;

public class TeachersDao {
	//method to Add teachers details
	public void insertTeachers(String teacher_id, String first_name, String last_name) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "insert into teachers values(?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, teacher_id);
			pstmt.setString(2, first_name);
			pstmt.setString(3, last_name);

			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" Teacher data inserted successfully");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//method to display all teachers
	public void displayTeachers() {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select * from teachers ORDER BY teacher_id";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("teacher_ID" + " " + "first_name" + " " + "last_name");
			System.out.println("-------" + " " + "---------" + " " + "---------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + "   " + rs.getString(3));
				System.out.println();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//method to validate if teacher id entered already present or not
	public boolean teacherIdValidation(String teacher_id) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select teacher_id from teachers where teacher_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, teacher_id);

			int status = pstmt.executeUpdate();

			if (status > 0) {
				flag = true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
