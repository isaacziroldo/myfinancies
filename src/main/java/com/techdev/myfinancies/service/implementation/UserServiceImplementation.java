package com.techdev.myfinancies.service.implementation;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techdev.myfinancies.exception.AutenticateErrorException;
import com.techdev.myfinancies.exception.BusinessRuleException;
import com.techdev.myfinancies.model.entity.User;
import com.techdev.myfinancies.model.repository.UserRepository;
import com.techdev.myfinancies.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository repository;
	
	@Autowired
	public UserServiceImplementation(UserRepository Repository) {
		super();
		this.repository = Repository;
	}

	@Override
	public User autenticate(String email, String password) {
		Optional<User> user = repository.findByEmail(email);
		
		if(!user.isPresent()) {
			throw new AutenticateErrorException("Usuário não encontrado");
		}
		
		if(!user.get().getPassword().equals(password)) {
			throw new AutenticateErrorException("Senha válida");
		}
		
		return user.get();
	}

	@Override
	@Transactional
	public User signUp(User user) {
		validateEmail(user.getEmail());
		return repository.save(user);
	}

	@Override
	public void validateEmail(String email) {
		boolean exist = repository.existsByEmail(email);
		
		if(exist) {
			throw new BusinessRuleException("Já existe um usuário cadastrado com esse email.");
		}
	}

}
