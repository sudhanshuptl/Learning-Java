package com.codecops.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc {

	public static void main(String[] args) throws SQLException {

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
		
		Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//stmt.setMaxRows(5); //set max no of row result set can take
		//This will be used for update,insert etc
		//stmt.executeUpdate("insert,update query")
//		ResultSet rs=stmt.executeQuery("Select * from Employees"); //used to execute query
//		while(rs.next()){
//			System.out.println(rs.getInt(1)+"   "+rs.getString("FIRST_NAME"));
//		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("\t1 for insert\n\t2 for view all field\n\n\t your option : ");
//		int options= sc.nextInt();
//		switch(options){
//			case 1:
//				System.out.print("InputId =");
//				int id=sc.nextInt();
//				System.out.print("\n Name =");
//				String name=sc.next();
//				System.out.print("\nDepartment Name =");
//				int deptId=sc.nextInt();
//				stmt.executeUpdate("Insert into testy values("+id+",\'"+name+"\',"+deptId+")");
//				System.out.println("Insert SuccesFull");
//				break;
//			case 2:
//				System.out.println("\n All data");
//				ResultSet rs = stmt.executeQuery("Select * from Testy");
//				rs.afterLast();
//				while(rs.previous()){
//					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
//				}
//				break;
//		}
		
		ResultSet rs = stmt.executeQuery("Select id,name from Testy");
		System.out.println(rs.getMetaData());
		while(rs.next()){
			if(rs.getInt("ID")==45)
				rs.rowDeleted();
			else
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t");
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		 }
		finally{
			 conn.close();
		}
	}
}