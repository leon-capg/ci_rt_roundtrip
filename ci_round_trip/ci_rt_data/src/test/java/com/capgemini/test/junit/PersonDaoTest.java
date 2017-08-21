package com.capgemini.test.junit;

import java.util.List;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.test.AppConfig;
import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.data.PersonBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class PersonDaoTest {
	
	@Autowired
	PersonDao personDao;
	
	@Test
	public void list() {
		List<PersonBean> personList = personDao.list();
		AssertionsForClassTypes.assertThat(personList)
		.isNotNull()
		.asList()
		.size().isGreaterThan(0);
	}

}
