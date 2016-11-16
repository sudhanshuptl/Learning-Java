package com.java.BulkQuery;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
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
		configuration.configure("hibernate.cfg5.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		

		Transaction transaction = session.beginTransaction();
//		Cars car1=new Cars("toyata");
//		Cars car2=new Cars("lambo");
		//inserting
		//session.save(car1);
		//session.save(car2);
		/*
		Query query =session.createQuery("select car from Cars car");
		List<Cars> carl= query.list();
		for(Cars c: carl){
			System.out.println(c.getCarName());
		}
		*/
		
		/*
		Query query =session.createQuery("select car.carName from Cars car");
		List<Object> carl=  query.list();
		for(Object obj:carl){
			System.out.println(obj.toString());
		}
		*/
		/*
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Car Id :");
		int inp= sc.nextInt();
		*/
		/*
		Query query =session.createQuery("select max(car.carId) from Cars car");
	
		Iterator<Object> obj =query.iterate();
		while(obj.hasNext()){
			Object projectObj=obj.next();
			System.out.println(projectObj.toString());
		}
		*/
		Query query = session.getNamedQuery("basic");
		Iterator<Cars> obj =query.iterate();
		while(obj.hasNext()){
			Cars projectObj=obj.next();
			System.out.println(projectObj.getCarName());
		}
//		Cars carIt=query.iterate();
//		System.out.println(carIt);
		
		transaction.commit();
		session.close();
		sessionFactory.close();


	}

}
