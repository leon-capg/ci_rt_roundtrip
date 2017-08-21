package com.capgemini.test.dao;

import java.util.List;

import com.capgemini.test.data.PersonBean;

public interface PersonDao {

	List<PersonBean> list();
	
	PersonBean get(int id);
	
	boolean add(PersonBean person);
	
	boolean update(PersonBean person);
	
	boolean delete(int id);
}
