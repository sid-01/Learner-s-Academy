package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbConnection.DBConnection;

public class StudentsDao {

	public void insertStudents(String stud_Id, String first_name, String last_name, String stud_class) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "insert into students values(?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, stud_Id);
			pstmt.setString(2, first_name);
			pstmt.setString(3, last_name);
			pstmt.setString(4, stud_class);
			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" student data inserted successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void displayStudents() {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select * from students ORDER BY stud_id";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("stud_ID" + "\t" + "first_name" + " " + "last_name" + " " + "Class");
			System.out.println("-------" + "\t" + "---------" + " " + "---------" + " " + "---------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + "   " + rs.getString(3) + "\t"
						+ rs.getString(4));
				System.out.println();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	//STUDENT DETAILS BY STUD_ID
	public void displayStudentsByClassNum(String class_num) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select stud_id,first_name,last_name from students where class_num=?  ORDER BY stud_id";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1,class_num);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("stud_ID" + "\t" + "first_name" + " " + "last_name");
			System.out.println("-------" + "\t" + "---------" + " " + "---------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + "   " + rs.getString(3));
				System.out.println();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	

	public boolean studentIdValidation(String stud_id) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select stud_id from students where stud_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, stud_id);

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
