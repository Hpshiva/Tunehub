package com.kodnest.Tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.Tunehub.entity.User;
import com.kodnest.Tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String userdate(@ModelAttribute User user)
	{	
		if(userService.postUserData(user)==true) {
			return "login";
		}
		else{
			return "registration";
		}
	}
	
	@PostMapping("/validate")
	public String login(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		if(userService.validUser(email,password)==true)
		{
			session.setAttribute("email", email);
			String role = userService.getRole(email);
			System.out.println(role);
			if(role.equals("Admin"))
				return "adminhome";
			else
				return "customerhome";
		}
		else
			return "login";
		
		
		
	}
	

}
