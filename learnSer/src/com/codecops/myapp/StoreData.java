package com.codecops.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StoreData extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
   
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		UserData data= new UserData();
		data.setFirstName(request.getParameter("first_name"));
		data.setLastName(request.getParameter("last_name"));
		data.setAge(Integer.valueOf((String) request.getParameter("age")));
		data.setEmail(request.getParameter("email"));
		data.setPassword(request.getParameter("passwd"));
		data.setGender(request.getParameter("gender"));
		data.setDesig(request.getParameter("desg"));
		data.setDoj(request.getParameter("doj"));
		data.setCity(request.getParameter("city"));
		data.setArea(request.getParameter("area"));
		
		/******************************* Hibernate ******************************/
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg4.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.save(data);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

		/*******************************End-Hibernate******************************/
		
		PrintWriter out = response.getWriter();
		out.println("Your Data is Succesfully Saved");
		out.close();
//		}
//		catch(Exception e){
//			PrintWriter out = response.getWriter();
//			out.println("Error in insertion :");
//			e.printStackTrace();
//			out.close();
//		}
		
	}

}
