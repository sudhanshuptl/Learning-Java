package com.codecops.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HandlingImage {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		
		try {
			// Alternate way of loading drivar
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			conn.setAutoCommit(false); //now changes are not auto commited
			
			FileInputStream fin = new FileInputStream("sherlock-sociopath.jpg");
			
			PreparedStatement stmt = conn.prepareStatement("insert into photos values(?,?)");
			
			stmt.setInt(1,1);
			stmt.setBlob(2, fin);
			stmt.executeUpdate();
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
