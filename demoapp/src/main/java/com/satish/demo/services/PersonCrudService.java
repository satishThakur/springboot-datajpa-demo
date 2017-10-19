package com.satish.demo.services;

import java.util.List;

import com.satish.demo.repository.Person;

public interface PersonCrudService {
	
	public void savePerson(Person person);
	
	public List<Person> getAllWithName(String name);
	
	public List<Person> getAllPeople();

}
