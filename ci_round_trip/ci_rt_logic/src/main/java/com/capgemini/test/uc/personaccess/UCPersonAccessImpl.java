package com.capgemini.test.uc.personaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.data.PersonBean;

public class UCPersonAccessImpl implements UCPersonAccess {

	@Autowired
	PersonDao personDao;
	
	@Override
	public List<PersonBean> list() {
		return personDao.list();
	}

	@Override
	public PersonBean get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
