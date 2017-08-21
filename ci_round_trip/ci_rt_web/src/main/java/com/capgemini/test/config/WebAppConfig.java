package com.capgemini.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.test.uc.personaccess.UCPersonAccess;
import com.capgemini.test.uc.personaccess.UCPersonAccessImpl;

@Configuration
@ComponentScan(basePackages = {"com.capgemini.test"})
public class WebAppConfig {

	@Bean
	public UCPersonAccess personAccess() {
		return new UCPersonAccessImpl();
	}
	
}
