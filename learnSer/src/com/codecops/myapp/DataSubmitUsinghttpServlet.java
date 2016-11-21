package com.codecops.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class DataSubmitUsinghttpServlet
 */
public class DataSubmitUsinghttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Session session;
	SessionFactory sessionFactory;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg4.xml");
		sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		session = sessionFactory.openSession();
		System.out.println("connection created");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try{
		session.close();
		sessionFactory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData data= new UserData();
		try{
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
		System.out.println("all data successfully recieved");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in recieving data");
		}
		/******************************* Hibernate ******************************/
		try{
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in transaction");
		}
		/*******************************End-Hibernate******************************/
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.println("Your Data is Succesfully Saved");
		out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://google.com\">");
		out.print("</html>");
		out.close();
	}

}
