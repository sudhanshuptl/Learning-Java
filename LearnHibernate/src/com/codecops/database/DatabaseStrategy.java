package com.codecops.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseStrategy {

	
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg2.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//inserting
		//session.save(emp1);
		//session.save(emp2);
		
		//Update
//		Employee emp3 =new Employee();
//		emp3.setEmployeeId(1002);
//		emp3.setEmployeeName("shan");
//		emp3.setPhoneNumber(2423423);
//		emp3.setSalary(23234);
//		session.update(emp3);
		
		transaction.commit();
		session.close();
		sessionFactory.close();


	}

}
