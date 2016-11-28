package com.virtusa.spring.mvc;

public class UserBean {
	String name;
	String pass;
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
		return "UserBean [name=" + name + ", pass=" + pass + "]";
	}
	
}
