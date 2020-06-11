package com.techdev.myfinancies.service;

import com.techdev.myfinancies.model.entity.User;

public interface UserService {
	
	User autenticate(String email,String password);

	User signUp(User user);
	
	void validateEmail(String email);
}
