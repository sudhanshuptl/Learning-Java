package com.virtusa.myapp.client;

import com.virtusa.myapp.Employee; //import class from other package
import com.virtusa.myapp.Name; 

public class EmployeeMain {
	public static void main(String[] args){
		Employee emp1=new Employee();
		emp1.name= new Name();
		emp1.name.firstName ="Sudhanshu";
		System.out.println(emp1.name.firstName);
		
	}
}
