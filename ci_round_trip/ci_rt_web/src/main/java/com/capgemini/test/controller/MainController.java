package com.capgemini.test.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.capgemini.test.data.PersonBean;
import com.capgemini.test.model.PersonGUI;
import com.capgemini.test.uc.personaccess.PersonService;

@Component("main")
@Scope("request")
public class MainController implements Serializable {
	
	private static final long serialVersionUID = 7107822387957765939L;
	private List<PersonGUI> personList;
	
	@Autowired
	PersonService personAccess;
	
	public List<PersonGUI> readPersonList() {
		List<PersonBean> beanList = personAccess.list();
		List<PersonGUI> guiList = new ArrayList<>();
		for(PersonBean bean : beanList) {
			guiList.add(DozerBeanMapperSingletonWrapper.getInstance().map(bean, PersonGUI.class));
		}
		return guiList;
	}
	
	public List<PersonGUI> getPersonList() {
		if(personList == null) {
			personList = readPersonList();
			System.out.println("[" + System.currentTimeMillis() + "] reading person list...");
		}
		return personList;
	}
	
	public void addPerson() {
	}
}
