package DAO;

import java.sql.*;

public class Database {

	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost/books";
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
			return null;
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
