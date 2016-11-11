package com.codecops.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LearnBatch {

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
			
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			stmt.addBatch("update testy set id=20 where id=23");
			stmt.addBatch("update testy set id=50 where id=121");
			
			stmt.executeBatch();
			System.out.println("Batch Succesfuuly executed");
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
