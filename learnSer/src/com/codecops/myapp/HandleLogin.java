package com.codecops.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class HandleLogin
 */
public class HandleLogin extends GenericServlet  {
	private static final long serialVersionUID = 1L;
       
    
 
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		
		PrintWriter out = response.getWriter(); //create stream
		out.println("User name : "+user+"<br/>");
		out.print("password :"+pass);
		out.close();
	}

}
