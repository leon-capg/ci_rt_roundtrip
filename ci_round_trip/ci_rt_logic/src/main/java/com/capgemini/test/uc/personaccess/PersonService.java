package com.capgemini.test.uc.personaccess;

import java.util.List;

import com.capgemini.test.data.PersonBean;

public interface PersonService {

	List<PersonBean> list();
	
	PersonBean get(int id);
	
	boolean add(PersonBean person);
	
	boolean update(PersonBean person);
	
	boolean delete(int id);
	
}
