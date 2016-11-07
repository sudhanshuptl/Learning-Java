package com.codecops.lms;

public class Admin extends Users {

	Admin(int userId, String name, long mobileNumber, String passwd) {

		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.mobileNumber = mobileNumber;

	}

	public boolean checkLogin(int adminId, String adminPassword) {

		if (adminId == this.userId && adminPassword.equals(this.passwd)) {
			return true;
		}
		return false;
	}

	public void setUserId(int userId) {
		super.userId = userId;
	}
	public void setName(String name) {
		super.name = name;
	}
	public void setMobileNumber(long mobileNumber) {
		super.mobileNumber = mobileNumber;
	}
	public void setPasswd(String passwd) {
		super.passwd = passwd;
	}
}
