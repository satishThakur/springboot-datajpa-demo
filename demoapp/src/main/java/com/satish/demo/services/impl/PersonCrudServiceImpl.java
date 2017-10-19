package com.satish.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.demo.repository.Person;
import com.satish.demo.repository.PersonRepository;
import com.satish.demo.services.PersonCrudService;

@Service("personCrudService")
public class PersonCrudServiceImpl implements PersonCrudService{
	
	private PersonRepository personRepo;
	
	@Autowired
	public PersonCrudServiceImpl(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public void savePerson(Person person) {
		personRepo.save(person);
		
	}

	@Override
	public List<Person> getAllWithName(String name) {		
		return personRepo.findByName(name);
	}

	@Override
	public List<Person> getAllPeople() {
		return personRepo.findAll();
	}

}
