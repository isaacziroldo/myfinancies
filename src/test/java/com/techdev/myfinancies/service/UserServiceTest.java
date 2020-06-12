package com.techdev.myfinancies.service;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.techdev.myfinancies.exception.BusinessRuleException;
import com.techdev.myfinancies.model.repository.UserRepository;
import com.techdev.myfinancies.service.implementation.UserServiceImplementation;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {
	
	public static String EMAIL = "isaac@email.com"; 
	public static String NOME = "isaac"; 
	
	
	UserService service;
	UserRepository  repository;
	
	@BeforeEach
	public void setUp() {
		repository = Mockito.mock(UserRepository.class);
		service = new UserServiceImplementation(repository);
	}
	
	@Test
	public void mustVerifyEmail() {
		
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		
		service.validateEmail("isaac@gmail.com");
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		  org.junit.jupiter.api.Assertions.assertThrows(BusinessRuleException.class, () -> {
			
			Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
 
			
			service.validateEmail(EMAIL);
		});
	}

}
