package com.codecops.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Thecaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tester tester =new Tester("chandan",10000,23);
		Developer devp = new Developer("sudhanshu",12312,2345);
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg2.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		

		Transaction transaction = session.beginTransaction();
		//inserting
		session.save(tester);
		session.save(devp);
		
	
		
		transaction.commit();
		session.close();
		sessionFactory.close();


	}

}
