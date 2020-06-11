package com.techdev.myfinancies.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techdev.myfinancies.model.entity.User;

@SpringBootTest
@RunWith(SpringRunner.class)
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
	
}
