package com.capgemini.test.uc.personaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.data.PersonBean;

public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	@Override
	public List<PersonBean> list() {
		return personDao.list();
	}

	@Override
	public PersonBean get(int id) {
		return personDao.get(id);
	}

	@Override
	public boolean add(PersonBean person) {
		return personDao.add(person);
	}

	@Override
	public boolean update(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		return personDao.delete(id);
	}

}
