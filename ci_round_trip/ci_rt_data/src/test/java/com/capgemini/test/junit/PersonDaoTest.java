package com.capgemini.test.junit;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.test.config.AppConfig;
import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.data.PersonBean;
import com.capgemini.test.testconfig.TestPersistenceJPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestPersistenceJPAConfig.class, AppConfig.class})
public class PersonDaoTest {
	
	@Autowired
	PersonDao personDao;
	
	@Test
	@Transactional
	@Rollback(true)
	public void add() {
		AssertionsForClassTypes.assertThat(personDao.add(createPersonBean()));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void list() {
		personDao.add(createPersonBean());		
		List<PersonBean> personList = personDao.list();
		AssertionsForClassTypes.assertThat(personList)
		.isNotNull()
		.asList()
		.size().isGreaterThan(0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void get() {
		personDao.add(createPersonBean());
		int id = personDao.list().get(0).getId();
		AssertionsForClassTypes.assertThat(personDao.get(id)).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		personDao.add(createPersonBean());
		int id = personDao.list().get(0).getId();
		AssertionsForClassTypes.assertThat(personDao.delete(id)).isTrue();
	}
	
	public PersonBean createPersonBean() {
		PersonBean bean = new PersonBean();
		bean.setFirstName("Max");
		bean.setLastName("Muster");
		bean.setAge(30);
		return bean;
	}

}
