package com.capgemini.test.dao;

import java.util.List;

import com.capgemini.test.data.PersonBean;

/**
 * 
 * @author lbeutl
 *
 * Person database access object class
 */
public interface PersonDao {

	/**
	 * @return all {@link PersonBean} from the database
	 */
	List<PersonBean> list();
	
	/**
	 * @param id of {@link PersonBean} to return
	 * @return a single {@link PersonBean} from the database
	 */
	PersonBean get(int id);
	
	/**
	 * @param {@link PersonBean} to add to the database
	 * @return true if transaction was successful
	 */
	boolean add(PersonBean person);
	
	/**
	 * @param {@link PersonBean} to update the database entry for
	 * @return true if transaction was successful
	 */
	boolean update(PersonBean person);
	
	/**
	 * @param id of {@link PersonBeam} to delete database entry for
	 * @return true if transaction was successful
	 */
	boolean delete(int id);
}
