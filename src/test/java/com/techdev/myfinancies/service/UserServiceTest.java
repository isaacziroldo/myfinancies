package com.techdev.myfinancies.service;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.techdev.myfinancies.exception.BusinessRuleException;
import com.techdev.myfinancies.model.entity.User;
import com.techdev.myfinancies.model.repository.UserRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {
	
	public static String EMAIL = "isaac@email.com"; 
	public static String NOME = "isaac"; 
	
	@Autowired
	UserService service;
	
	@Autowired
	UserRepository  repository;
	
	@Test
	public void mustVerifyEmail() {
		
		repository.deleteAll();
		
		service.validateEmail("isaac@gmail.com");
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		  org.junit.jupiter.api.Assertions.assertThrows(BusinessRuleException.class, () -> {
			
			User user = User.builder().name(NOME).email(EMAIL).build();		
			repository.save(user);
 
			
			service.validateEmail(EMAIL);
		});
	}

}
