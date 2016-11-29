package com.virtusa.spring.mvc;

import java.util.ArrayList;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean {
	/*
	 * validation anotations
	 * @Range(min=10,max=60,message="Age Should be greater than10 and less than 60")
	 * @Email
	 * 
	 */
	@NotEmpty(message="Enter User Name") //hibernate based validation
	String name;
	@NotEmpty(message="Enter Password")
	String pass;
	ArrayList<String> pl;
	
	
	public ArrayList<String> getPl() {
		return pl;
	}
	public void setPl(ArrayList<String> pl) {
		this.pl = pl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserBean [name=" + name + ", pass=" + pass + ", pl=" + pl + "]";
	}
	
}
