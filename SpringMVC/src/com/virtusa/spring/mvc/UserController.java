package com.virtusa.spring.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("User Controller!!!!!!!!!");
	}
	
	@RequestMapping("/greet")
	@ResponseBody // if we dont write this then Welcome become response page not string
	public String greet(){
		return "Welcome";
	}
	
	@RequestMapping("/")
	public String userhome() {
		return "userhome";
	}
	
	@RequestMapping("/registration")
	public String registration(){
		return "register";
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
}
