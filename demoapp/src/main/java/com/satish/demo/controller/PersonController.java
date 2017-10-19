package com.satish.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satish.demo.api.PersonVO;
import com.satish.demo.repository.Person;
import com.satish.demo.services.PersonCrudService;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	private PersonCrudService personservice;

	@Autowired
	public PersonController(PersonCrudService personservice) {
		this.personservice = personservice;
		
	}

	@RequestMapping(method=RequestMethod.POST,produces="application/json", consumes="application/json")
	public boolean createPerson(@RequestBody @Valid PersonVO personVO) {
		LOGGER.info("Request to create person: {}", personVO);
		Person person = new Person();
		person.setName(personVO.getName());
		person.setEmail(personVO.getEmail());
		personservice.savePerson(person);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public List<PersonVO> getAllPeople(){
		
		return personservice.getAllPeople().stream().map(
				p -> new PersonVO(p.getName(), p.getEmail()))
				.collect(Collectors.toList());
	}

}
