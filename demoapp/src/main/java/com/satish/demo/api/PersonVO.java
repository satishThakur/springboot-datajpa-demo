package com.satish.demo.api;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonVO {
	
	@NotNull
	@NotEmpty
	private final String name;
	
	@NotNull
	@NotEmpty
	@Email
	private final String email;
	
	@JsonCreator
	public PersonVO(@JsonProperty("name") String name, @JsonProperty("email") String email) {
		this.name = name;
		this.email = email;
		
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", email=" + email + "]";
	}

}
