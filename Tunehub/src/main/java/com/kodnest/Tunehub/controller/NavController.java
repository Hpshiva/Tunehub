package com.kodnest.Tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration()
	{
		return "registration";
	}
	
	@GetMapping("/index")
	public String invalid()
	{
		return "index";
	}
	@GetMapping("/forgot-password")
	public String forgot()
	{
		return "forgot";
	}

}
