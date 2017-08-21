package com.capgemini.test.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component ("person")
@Scope ("request")
public class PersonGUI {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age = 10;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
