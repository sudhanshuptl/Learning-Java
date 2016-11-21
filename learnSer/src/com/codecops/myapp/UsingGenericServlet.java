package com.codecops.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class UsingGenericServlet
 */
public class UsingGenericServlet extends GenericServlet {
	
	/**
	 * 
	 */
	

	@Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException

   {

      PrintWriter out = res.getWriter();

      String login= req.getParameter("loginid");

      String password= req.getParameter("password");

      out.print("You have successfully login :");

      out.println("Your login ID is: "+login);

      out.println("Your password is: " +password);

      out.close();

   }
	
   
}
