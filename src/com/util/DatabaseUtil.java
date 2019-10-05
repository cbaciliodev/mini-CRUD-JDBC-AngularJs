package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class DatabaseUtil {
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	private static final String sqlDriver = "org.sqlite.JDBC";
	private static final String oracleUrl = "jdbc:oracle:thin:@172.24.130.62:1521:xe";
	private static final String sqlUrl = "jdbc:sqlite:C:\\Users\\1434979\\MySQLiteDB";

	private static final String oracleUserId = "AE142668";
	private static final String oraclePassword = "AE142668";
	private static final String sqlUserId = "";
	private static final String sqlPassword = "";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(sqlDriver);
			con = DriverManager.getConnection(sqlUrl, sqlUserId, sqlPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
