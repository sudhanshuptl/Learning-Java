package com.virtusa.myapp.persist;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import javax.persistence.Table;


//persistence class
//Class level annotation
@Entity
@Table(name="EmployeeTBL")
@SecondaryTable(name="Address")
public class Employee2 implements Serializable {
	// Id is primary element,so it is must, if i did not map manually it automatilcally map
	@Id
	@Column(name="Emp_Id",length=10)
	private int employeeId;
	@Column(name="Emp_Name",length=50)
	String employeeName;
	@Column(name="sal",length=10)
	private double salary;
	@Column(name="phone",length=10)
	private long phoneNumber;
	@Column(table="Address")
	private String city;
	@Column(table="Address")
	private int pincode;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
