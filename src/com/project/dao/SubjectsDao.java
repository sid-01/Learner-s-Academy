package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbConnection.DBConnection;

public class SubjectsDao {
	
	public void insertSubject(String sub_id,String sub_name) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "insert into subjects(sub_id,sub_name) values(?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, sub_id);
			pstmt.setString(2, sub_name);
			
			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" subject data inserted successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void displaySubjects() {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select * from subjects ORDER BY sub_id";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("subj_ID" + "\t" + "subject_name" + " " + "class_num" + " " + "Teacher");
			System.out.println("-------" + "\t" + "------------" + " " + "---------" + " " + "---------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + " " + "   " + rs.getString(3) + "\t"
						+ rs.getString(4));
				System.out.println();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

	public boolean subjIdIdValidation(String sub_id) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select sub_id from subjects where sub_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, sub_id);

			int status = pstmt.executeUpdate();

			if (status > 0) {
				flag = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public void AssignClassToSubject(String class_id,String sub_id)
	{
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "update subjects set class_id=? where sub_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, class_id);
			pstmt.setString(2, sub_id);
			
			
			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" Class has been assigned successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void AssignTeacherToSubject(String teacher_id,String sub_id)
	{
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "update subjects set teacher_id=? where sub_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, teacher_id);
			pstmt.setString(2, sub_id);
			
			
			int status = pstmt.executeUpdate();

			if (status > 0) {
				System.out.println(" Teacher has been assigned successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void displaySubjectsByClassNum(String class_num) {
		try {
			Connection conn = DBConnection.getConnection();
			String sqlQuery = "select sub_id,sub_name,teacher_id from subjects where class_id=?  ORDER BY sub_id";

			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1,class_num);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("sub_ID" + " " + "subject_name"+" " + "teacher_id");
			System.out.println("------" + " " + "------------"+" " + "-----------");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+"\t"+rs.getString(3));
				System.out.println();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	}



  