package com.virtusa.spring.mvc;

import java.util.ArrayList;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserFormValidation implements Validator {

	@Override
	public boolean supports(Class<?> object) {
		return UserBean.class.equals(object);
		//is object is of type UserBean
	}

	@Override
	public void validate(Object  object, Errors error) {
		// This is another manual validation
		// we can also use hibernate validation then we don't have to write anything
		UserBean userBean = (UserBean) object;
		String name = userBean.getName();
		String pass = userBean.getPass();
		ArrayList<String> pl = userBean.getPl();
		if(name==null || name.isEmpty()){
			error.rejectValue("name","name", "Please Fill the User Name");
		}
		if(pass==null || pass.isEmpty()){
			error.rejectValue("pass","pass", "Please Fill the User Password");
		}
		if(pl==null){
			error.rejectValue("pl","pass", "Please Fill Programmin lange");
		}
		
	}


	
}
