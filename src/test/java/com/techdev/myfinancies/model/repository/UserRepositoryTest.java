package com.techdev.myfinancies.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.techdev.myfinancies.model.entity.User;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void mustVerifyEmailExistence() {
		
		User user = createUser();
		entityManager.persist(user);
		
		boolean result = repository.existsByEmail("isaac@gmail.com");
		
		Assertions.assertThat(result).isTrue();
	
	}
	
	@Test
	public void falseWhenUserNotRegistered() {
		
		
		boolean result = repository.existsByEmail("tito@gmail.com");
		
		Assertions.assertThat(result).isFalse();
	}
	
	public void devePersistirUmUsuarioNaBaseDeDados() {
		User user = createUser();
		
		User savedUser = repository.save(user);
		
		Assertions.assertThat(savedUser.getId()).isNotNull();
	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		User user = createUser();
		entityManager.persist(user);
		
		Optional <User> result = repository.findByEmail("isaac@gmail.com");
		
		Assertions.assertThat(result.isPresent()).isTrue();
		
		
	}	
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmail() {
		
		
		Optional <User> result = repository.findByEmail("isaac@gmail.com");
		
		Assertions.assertThat(result.isPresent()).isFalse();
		
		
	}	
	
	public static User createUser() {
		return User.builder()
				.name("isaac")
				.email("isaac@gmail.com")
				.password("123456")
				.build();
	}
	
}
