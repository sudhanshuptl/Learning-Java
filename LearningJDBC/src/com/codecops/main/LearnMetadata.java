package com.codecops.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LearnMetadata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JDBC driver name and database URL
		// String DB_URL = "jdbc:oracle:thin:@172.23.179.59:1521:xe"; //using ip
		// of other pc
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		// Database credentials
		String USER = "hr";
		String PASS = "hr";
		Connection conn = null;

		try {
			// Register driver //Step 1 of JDBC
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// make connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(conn.getMetaData());
			DatabaseMetaData mData = conn.getMetaData();// connection is a
																// valid object
																// of Connection
																// interface 
			System.out.println("db major: " + mData.getDatabaseMajorVersion());
			System.out.println("db minor: " + mData.getDatabaseMinorVersion());
			System.out.println(mData.getDatabaseProductName());
			System.out.println(mData.getDatabaseProductVersion());
			System.out.println(mData.getDriverName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
