package com.java.relationsTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Thecaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg4.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		

		Transaction transaction = session.beginTransaction();
		Cars car = new Cars();
		Person per = new Person();
		//inserting
		session.save(car);
		session.save(per);
		
	
		
		transaction.commit();
		session.close();
		sessionFactory.close();


	}

}
