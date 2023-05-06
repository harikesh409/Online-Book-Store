package com.example.dao;

import java.sql.*;

public class Database {

	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/books";
	private static final String USER = "root";
	private static final String PASS = "root";

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
//			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
