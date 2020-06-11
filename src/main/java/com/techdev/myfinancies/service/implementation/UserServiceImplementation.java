package com.techdev.myfinancies.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techdev.myfinancies.exception.BusinessRuleException;
import com.techdev.myfinancies.model.entity.User;
import com.techdev.myfinancies.model.repository.UserRepository;
import com.techdev.myfinancies.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
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
		boolean exist = userRepository.existsByEmail(email);
		
		if(exist) {
			throw new BusinessRuleException("Já existe um usuário cadastrado com esse email.");
		}
	}

}
