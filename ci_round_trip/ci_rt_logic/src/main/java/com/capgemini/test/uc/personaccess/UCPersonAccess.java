package com.capgemini.test.uc.personaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.test.dao.PersonDao;
import com.capgemini.test.data.PersonBean;

public interface UCPersonAccess {

	List<PersonBean> list();
	
	PersonBean get(int id);
	
	boolean add(PersonBean person);
	
	boolean update(PersonBean person);
	
	boolean delete(int id);
	
}
