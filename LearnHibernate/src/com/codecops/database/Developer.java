package com.codecops.database;

import javax.persistence.Entity;

@Entity
public class Developer extends EmployeeN{

	private long lineOfCode;
	
	public Developer(String name,int sal,int lcode){
		//super.setEmployeeId(id);
		this.lineOfCode=lcode;
		super.setEmployeeName(name);
		super.setSalary(sal);
	}

	
	public long getLineOfCode() {
		return lineOfCode;
	}

	public void setLineOfCode(long lineOfCode) {
		this.lineOfCode = lineOfCode;
	}
	
}
