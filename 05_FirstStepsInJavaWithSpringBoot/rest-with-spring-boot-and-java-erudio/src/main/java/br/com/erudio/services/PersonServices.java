package br.com.erudio.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong count = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		
		logger.info("Finding all people!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
		
	}
	
	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(count.incrementAndGet());
		person.setFirstName("Julliano");
		person.setLastName("Moreira");
		person.setAddress("Eldorado do Sul - Rio Grande do Sul - Brasil");
		person.setGender("Male");
		return person;
		
	}
	
	public Person create(Person person) {
		logger.info("Create one Person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one Person!");
		//return person;
	}
	
	private Person mockPerson(int i) {
		++i;
		Person person = new Person();
		person.setId(count.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}
}
