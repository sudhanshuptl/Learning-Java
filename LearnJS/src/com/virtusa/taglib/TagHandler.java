package com.virtusa.taglib;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagHandler extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		String greet =null;
		JspWriter out = getJspContext().getOut();
		Calendar cal = new GregorianCalendar();
		int ampm = cal.get(Calendar.AM_PM);
		Date date = cal.getTime();
		if(ampm ==0 ){
			greet="Good morning, The current time"+date;
		}
		else{
			greet="Good evening, The current time"+date;
		}
		out.print(greet);
	}

}
