package com.virtusa.myapp.persist;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//persistence class
//Class level annotation
@Entity
@Table(name="EmployeeTBL")
public class Employee5 implements Serializable {
	// Id is primary element,so it is must, if i did not map manually it automatilcally map
	@Id
	@Column(name="Emp_Id",length=10)
	private int employeeId;
	@Column(name="Emp_Name",length=50)
	String employeeName;
	@Column(name="sal",length=10)
	private double salary;

	
	@ElementCollection
	private HashSet<Long> phone;

	

	public HashSet<Long> getPhone() {
		return phone;
	}
	public void setPhone(HashSet<Long> phone) {
		this.phone = phone;
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


}
