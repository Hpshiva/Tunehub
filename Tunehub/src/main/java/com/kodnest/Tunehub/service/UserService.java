package com.kodnest.Tunehub.service;

import com.kodnest.Tunehub.entity.User;



public interface UserService {
	
boolean postUserData(User user);

boolean validUser(String email, String password);

String getRole(String email);

	

}
