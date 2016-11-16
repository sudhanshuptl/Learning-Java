package com.java.relations;

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
		configuration.configure("hibernate.cfg3.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		

		Transaction transaction = session.beginTransaction();
		Passport pass = new Passport();
		Person per = new Person();
		//inserting
		session.save(pass);
		session.save(per);
		
	
		
		transaction.commit();
		session.close();
		sessionFactory.close();


	}

}
