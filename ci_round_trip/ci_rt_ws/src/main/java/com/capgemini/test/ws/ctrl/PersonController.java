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

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(path="/person")
	public List<PersonWS> getPersonList() {
		List<PersonBean> beanList = personService.list();
		List<PersonWS> wsList = new ArrayList<>();
		for(PersonBean bean : beanList) {
			wsList.add(DozerBeanMapperSingletonWrapper.getInstance().map(bean, PersonWS.class));
		}
		return wsList;
	}
	
	@RequestMapping(path="/person/{id}")
	public PersonWS getPerson(@PathVariable("id") Integer id) {
		return DozerBeanMapperSingletonWrapper.getInstance().map(personService.get(id), PersonWS.class);
	}
	
}
