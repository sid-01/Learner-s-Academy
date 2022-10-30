package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection conn = null;
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String USER_NAME = "c##tester";
	private final static String PASSWORD = "tester123";

	public static Connection getConnection() {
		if (conn == null) {

			try {
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			}

			// System.out.println("connected");
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;

	}
}
