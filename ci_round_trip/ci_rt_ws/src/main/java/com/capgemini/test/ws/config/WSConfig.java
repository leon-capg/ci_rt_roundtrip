package com.capgemini.test.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.capgemini.test.uc.personaccess.PersonService;
import com.capgemini.test.uc.personaccess.PersonServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.capgemini.test"})
public class WSConfig {
	
	@Bean
	public PersonService personAccess() {
		return new PersonServiceImpl();
	}

}
