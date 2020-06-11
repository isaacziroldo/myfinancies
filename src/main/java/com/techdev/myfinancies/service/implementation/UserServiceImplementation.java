package com.techdev.myfinancies.service.implementation;

import com.techdev.myfinancies.model.entity.User;
import com.techdev.myfinancies.model.repository.UserRepository;
import com.techdev.myfinancies.service.UserService;

public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;

	
	
	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User autenticate(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signUp(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateEmail(String email) {
		// TODO Auto-generated method stub
		
	}

}
