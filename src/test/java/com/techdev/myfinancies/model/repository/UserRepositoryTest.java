package com.techdev.myfinancies.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.techdev.myfinancies.model.entity.User;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	
	@Test
	public void mustVerifyEmailExistence() {
		
		User user = User.builder().name("isaac").email("isaac@gmail.com").build();
		repository.save(user);
		
		boolean result = repository.existsByEmail("isaac@gmail.com");
		
		Assertions.assertThat(result).isTrue();
	
	}
	
	@Test
	public void falseWhenUserNotRegistered() {
		repository.deleteAll();
		
		boolean result = repository.existsByEmail("tito@gmail.com");
		
		Assertions.assertThat(result).isFalse();
	}
	
}
