package com.test;

import java.util.ArrayList;
import java.util.Iterator;

public class CallerMain {

	public String printTab(){
		User u1= new User();
		u1.setId(10);
		u1.setName("Sud");
		
		User u2= new User();
		u2.setId(10);
		u2.setName("Sud");
		
		User u3= new User();
		u3.setId(10);
		u3.setName("Sud");
		
		ArrayList<User> usr = new ArrayList<User>();
		usr.add(u1);
		usr.add(u2);
		usr.add(u3);
		
		String st="";
		for(User us:usr){
			st=st.concat("<tr> <td>"+us.getId()+" </td> <td> "+us.getName()+" </td></tr>");
		}
		return st;
		
	}

}
