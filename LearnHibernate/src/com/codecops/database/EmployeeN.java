package com.codecops.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Inheritance  if we want all table merge to one

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class EmployeeN implements Serializable {
	@Id
	@Column(nullable=false)
	@GenericGenerator(
			name = "sequence", 
			strategy = "sequence", 
			parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "my_seq1")
	})
	@GeneratedValue(generator = "sequence") 
	private int employeeId;
	private String employeeName;
	private int salary;
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
}
