package com.capgemini.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.dao.PersonDaoImpl2;

@Configuration
@ComponentScan(basePackages = {"com.capgemini.test.data"})
public class AppConfig {
	
	@Bean
    public PersonDao personDao() {
        return new PersonDaoImpl2();
    }
	
}
