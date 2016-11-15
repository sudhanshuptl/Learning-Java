package com.codecops.database;

import javax.persistence.Entity;

@Entity
public class Tester extends EmployeeN {
	private int numberOfBugs;
	
	public Tester(String name,int sal,int bugs){
		//super.setEmployeeId(id);
		this.numberOfBugs=bugs;
		super.setEmployeeName(name);
		super.setSalary(sal);
	}

	
	public int getNumberOfBugs() {
		return numberOfBugs;
	}

	public void setNumberOfBugs(int numberOfBugs) {
		this.numberOfBugs = numberOfBugs;
	}
	
}
