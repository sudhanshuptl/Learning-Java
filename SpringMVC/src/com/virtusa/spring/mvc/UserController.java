package com.virtusa.spring.mvc;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("User Controller!!!!!!!!!");
	}
	
	/*
	@RequestMapping("/greet")
	@ResponseBody // if we dont write this then Welcome become response page not string
	public String greet(){
		return "Welcome";
	} */
	
	@RequestMapping("/greet") //sending data to view (we have to use mode)
	public String greet(Model model){
		//model object is created by container
		// here we can call hibernate to generate data
		model.addAttribute("date", new Date());
		ArrayList<String> list =new ArrayList<String>();
		list.add("Python");
		list.add("Angular");
		list.add("Time to Leave");
		model.addAttribute("list", list);
		return "Welcome";
	}
	
	@RequestMapping("/")
	public String userhome() {
		return "userhome";
	}
	
	@RequestMapping("/registration")
	public String registration(){
		//return "register";
		return "dynamicForm";
	}
	/*//using power of spring in next example
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String userName=request.getParameter("userName");
		String userPass = request.getParameter("password");
		
		if(userName.equals("sud") && userPass.equals("123")){
			return "success";
		}
		return "userhome";
	}*/
	@RequestMapping(value="/login",method=RequestMethod.POST) //invoke when request is post
	public String login(@RequestParam("userName") String name,@RequestParam("password") String password){
		if(name.equals("sud") && password.equals("123")){
			return "success";
		}
		return "userhome";
	
	}
	/*
	//Url of both is same
	@RequestMapping(value="/login",method=RequestMethod.GET) //invoke when request is get
	public String login1(@RequestParam("userName") String name,@RequestParam("password") String password){
		if(name.equals("sud") && password.equals("123")){
			return "success";
		}
		return "userhome";
	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET,params={"age","gender"}) 
	//invoke when request is get and with mentioned parameters here age and gender field and some other field can also be there
	public String login2(@RequestParam("userName") String name,@RequestParam("password") String password){
		if(name.equals("sud") && password.equals("123")){
			return "success";
		}
		return "userhome";
	
	}
	
	//How to store data in database
	@RequestMapping("/storeMyData")
	public String storeData(@ModelAttribute UserBean mybean){
		System.out.print(mybean); //just pass it to method to store it
		return "success";
	}
	//If you want session simply write HttpSession session 
	*/
	
	//dynamic mapping
	@RequestMapping("/dynamicform")
	public String DynamicForm(@ModelAttribute UserBean  user,Model model){
		//Note :modelAttribute="userBean"
		ArrayList<String> pl= new ArrayList<String>();
		pl.add("Java");
		pl.add("Python");
		
		model.addAttribute("pl", pl);
		return "dynamicForm"; //send data to form to make it dynamic
	}
	
	@RequestMapping(value="/storeDynamicform",method=RequestMethod.POST)
	public String storeFormData(Model model,@Valid @ModelAttribute UserBean user, BindingResult result){ //@Valid , BindingResults result
		//we can use manual validation here itself or we can seperate validation and spring will call it automaticaly
		//Below class is responsible for auto validating
		
		if(result.hasErrors()){
			ArrayList<String> pl= new ArrayList<String>();
			pl.add("Java");
			pl.add("Python");
			
			model.addAttribute("pl", pl);
			return "dynamicForm";
			
		}
		System.out.println(user);
		return "register"; //jsp page
		
	}
	/*// this is used for programatic validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		//This class automatically call for proper validater whenever it may required
		System.out.println("object validated");
		dataBinder.addValidators(new UserFormValidation());
	}
	*/
	
	//Using Hibernate declarative validation
	//We need to create anotation over UserBean;
}
