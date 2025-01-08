package com.md.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.md.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter =  new AtomicLong();
	
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Maurício" + i);
		person.setLastName("Dullius " + i);
		person.setFirstName("Maurício " + i);
		return person;
	}
	
	public Person create(Person person)
	{
		logger.info("Creating one person!");

		return person;
	}
	
	public Person update(Person person)
	{
		logger.info("Creating one person!");

		return person;
	}
	
	public void delete(String id)
	{
		logger.info("Deleting one person!");
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Maurício");
		person.setLastName("Dullius");
		person.setAddress("Lajeado - RS");
		person.setGender("Male");
		
		return person;
	}
	
	public List<Person> findAll() {
		
		logger.info("Finding all people!");
		
		List<Person> persons =  new ArrayList<>();
		
		for(int i = 0; i < 9 ; i++)
		{
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;	
	}
	
}
