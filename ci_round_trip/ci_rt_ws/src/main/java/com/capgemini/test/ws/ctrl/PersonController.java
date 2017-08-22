package com.capgemini.test.ws.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.test.data.PersonBean;
import com.capgemini.test.uc.personaccess.PersonService;
import com.capgemini.test.ws.model.PersonWS;

/**
 * 
 * @author lbeutl
 *
 * Rest service to retrieve {@link PersonWS} information from the application in JSON format
 */
@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	/**
	 * @return all {@link PersonWS} from the application as JSON object array.
	 */
	@RequestMapping(path="/person")
	public List<PersonWS> getPersonList() {
		List<PersonBean> beanList = personService.list();
		List<PersonWS> wsList = new ArrayList<>();
		for(PersonBean bean : beanList) {
			wsList.add(DozerBeanMapperSingletonWrapper.getInstance().map(bean, PersonWS.class));
		}
		return wsList;
	}
	
	/**
	 * @param id of {@link PersonWS} to return
	 * @return the {@link PersonWS} for the id
	 */
	@RequestMapping(path="/person/{id}")
	public PersonWS getPerson(@PathVariable("id") Integer id) {
		List<PersonBean> beanList = personService.list();
		PersonWS person = null;
		if(id != null) {
			for(PersonBean bean : beanList) {
				if(bean.getId() == id) {
					person = DozerBeanMapperSingletonWrapper.getInstance().map(bean, PersonWS.class);
				}
			}
		}
		return person;
	}
	
}
