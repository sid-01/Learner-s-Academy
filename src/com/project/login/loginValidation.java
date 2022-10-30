package com.project.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.dbConnection.DBConnection;

public class loginValidation {

	public static boolean login() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		String username = null;
		String password = null;
		String dbUsername = null;
		String dbPassword = null;
		boolean status = false;
		while (status == false) {
			try {
				Connection conn = DBConnection.getConnection();
				String sqlQuery = "select * from Admin";

				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					username = rs.getString(1);
					password = rs.getString(2);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Enter username and password for Admnin login");

			System.out.println("Username: ");
			dbUsername = sc.next();
			System.out.println("Password: ");
			dbPassword = sc.next();

			if (dbUsername.equalsIgnoreCase(username) && dbPassword.equals(password)) {
				flag = true;
				status = true;
			} else {
				System.out.println("Ivalid credentials! Please enter valid username and password");
			}
		}

		return flag;

	}
}
