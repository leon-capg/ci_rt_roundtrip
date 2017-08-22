package com.capgemini.test.uc.personaccess;

import java.util.List;

import com.capgemini.test.data.PersonBean;

/**
 * 
 * @author lbeutl
 *
 * Service class for simple person access use case
 */
public interface PersonService {

	/**
	 * @return all {@link PersonBean} from the application
	 */
	List<PersonBean> list();
	
	/**
	 * @param id of {@link PersonBean} to return
	 * @return a single {@link PersonBean}
	 */
	PersonBean get(int id);
	
	/**
	 * @param person the {@link PersonBean} to add to the application
	 * @return true if the entry was successfully added
	 */
	boolean add(PersonBean person);
	
	/**
	 * @param person the {@link PersonBean} to update in the application
	 * @return true if the entry was successfully edited
	 */
	boolean update(PersonBean person);
	
	/**
	 * @param id of the {@link PersonBean} to delete
	 * @return true if the entry was successfuly deleted
	 */
	boolean delete(int id);
	
}
