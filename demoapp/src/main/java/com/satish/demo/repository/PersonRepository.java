package com.satish.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public List<Person> findByName(String name);

}
