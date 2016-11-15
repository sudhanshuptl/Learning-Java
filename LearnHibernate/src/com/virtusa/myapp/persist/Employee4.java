package com.virtusa.myapp.persist;

import java.io.Serializable;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import javax.persistence.Table;


//persistence class
//Class level annotation
@Entity
@Table(name="EmployeeTBL")
public class Employee4 implements Serializable {
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
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city",column=@Column(name="homeTown")),
		@AttributeOverride(name="pincode",column=@Column(name="hPinCode"))
	})
	private Address tempAddr;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city",column=@Column(name="liveIn")),
		@AttributeOverride(name="pincode",column=@Column(name="LiveInPin"))
	})
	private  Address permAddr;
	
	

	public Address getTempAddr() {
		return tempAddr;
	}
	public void setTempAddr(Address tempAddr) {
		this.tempAddr = tempAddr;
	}
	public Address getPermAddr() {
		return permAddr;
	}
	public void setPermAddr(Address permAddr) {
		this.permAddr = permAddr;
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
