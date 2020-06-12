package com.techdev.myfinancies.model.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techdev.myfinancies.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Optional<User> finByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
