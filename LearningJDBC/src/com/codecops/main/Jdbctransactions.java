package com.codecops.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbctransactions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn=null;
		try {
			// Alternate way of loading drivar
			
				Class.forName("oracle.jdbc.OracleDrivar");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			conn.setAutoCommit(false); //now changes are not auto commited
			
			Statement stmt = conn.createStatement();
			
			stmt.addBatch("query1");
			stmt.addBatch("qury2");
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(ClassNotFoundException d){
			d.printStackTrace();
		}
		

	}

}
