package com.capgemini.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.dao.PersonDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.capgemini.test"})
public class AppConfig {
	
	@Bean
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }
	
	@Bean 
	public EntityManagerFactory entityManagerFactory() {
		return  Persistence.createEntityManagerFactory("test");
	}
	
}
