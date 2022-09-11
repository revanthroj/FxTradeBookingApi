package com.finzly.fxtradbooking.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {

	private static Connection con;
	private static JDBC_Connection getCon;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;

	private JDBC_Connection() {
		url = "jdbc:mysql://localhost:3306/sys";
		username = "root";
		password = "root";
		driver = "com.mysql.cj.jdbc.Driver";
	}

	public static Connection getConnection() {
		try {
			getCon = new JDBC_Connection();
			Class.forName(driver);
			 con = DriverManager.getConnection(url, username, password);
			 return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
