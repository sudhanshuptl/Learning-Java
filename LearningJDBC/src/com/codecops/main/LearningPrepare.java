package com.codecops.main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LearningPrepare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JDBC driver name and database URL
		//String DB_URL = "jdbc:oracle:thin:@172.23.179.59:1521:xe"; //using ip of other pc
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
			String query="insert into testy values(?,?,?)";
			//Used when we need to execute same query repeatativaly than it compile query once
			PreparedStatement stmt= conn.prepareStatement(query); 
			stmt.setInt(1, 121);
			stmt.setString(2, "Rahul");
			stmt.setInt(3, 24);
			stmt.execute();
			System.out.println("Insertion Succes !!");
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()){
//				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t");
//			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}
}
