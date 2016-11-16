package com.java.BulkQuery;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;

public class TheCriteriaCaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg5.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		
//		Cars car=new cars();
//		car.setCarId(2);
//		car.setCarName("vista");
		Criteria query=session.createCriteria(Cars.class);
		/*
		SimpleExpression sExp= Restrictions.le("carId", 2); //ge for greater than , eq=equal to
		SimpleExpression cond2 = Restrictions.ge("carId",1);
		LogicalExpression cond3 = Restrictions.and(sExp, cond2);
		query.add(cond3); // then these two condition by default "and"
		query.addOrder(Order.asc("carName")); //ordering
		
		List<Cars> carl=  query.list();
		for(Cars obj:carl){
			System.out.println(obj.getCarId()+"  "+obj.getCarName());
		}
		*/
		//Projection
		
		ProjectionList proj= Projections.projectionList();
		proj.add(Projections.property("carName"));
		proj.add(Projections.property("carId"));
		
		query.setProjection(proj);
		
		List<Object> lst = query.list();
		for(Object car:lst){
			Object[] ls =(Object[]) car;
			System.out.println(ls[0]+"   "+ls[1]);
		}
		
		
//		List<Cars> carl=  query.list();
//		for(Cars obj:carl){
//			System.out.println(obj.getCarId()+"   "+obj.getCarName());
//		}
		
		
		session.close();
		sessionFactory.close();


	}

}
