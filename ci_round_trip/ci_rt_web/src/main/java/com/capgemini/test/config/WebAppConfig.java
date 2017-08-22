package com.capgemini.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.test.uc.personaccess.PersonService;
import com.capgemini.test.uc.personaccess.PersonServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.capgemini.test"})
public class WebAppConfig {

	@Bean
	public PersonService personAccess() {
		return new PersonServiceImpl();
	}
	
}
