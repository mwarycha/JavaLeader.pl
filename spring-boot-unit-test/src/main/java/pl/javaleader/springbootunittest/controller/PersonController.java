package pl.javaleader.springbootunittest.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import pl.javaleader.springbootunittest.model.Person;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PersonController {

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public Person getPerson() {

		Person person = new Person();
		person.setUsername("James");
		person.setSurname("Spring");
		person.setSalary(1000);

		return person;
	}

}