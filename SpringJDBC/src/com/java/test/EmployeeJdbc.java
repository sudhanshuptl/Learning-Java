package com.java.test;
import org.springframework.jdbc.core.JdbcTemplate;


public class EmployeeJdbc {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void init(){
		if(jdbcTemplate!=null){
			System.out.println("object created");
		}
	}
	
	public void  insert() {
		
	}
}
