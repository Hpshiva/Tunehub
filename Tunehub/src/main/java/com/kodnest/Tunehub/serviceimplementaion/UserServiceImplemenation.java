package com.kodnest.Tunehub.serviceimplementaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.Tunehub.entity.User;
import com.kodnest.Tunehub.repository.UserRepository;
import com.kodnest.Tunehub.service.UserService;

@Service
public class UserServiceImplemenation implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean postUserData(User user)

	{
		 User existEmail= userRepository.findByEmail(user.getEmail());
		if(existEmail==null) {
			userRepository.save(user);
			return true;
		}
		else {
			System.out.println("duplicate");
			return false;
		}
	}

	@Override
	public boolean validUser(String email, String password) {
		User user=userRepository.findByEmail(email);
		String dbpwd = user.getPassword();
		if(password.equals(dbpwd))
			return true;
		else
			return false;
	}

	@Override
	public String getRole(String email) {
		
		User userDB = userRepository.findByEmail(email);
		String role = userDB.getRole();
		
		return role;
	}

	
	
}
