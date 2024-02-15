package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	//private final AtomicLong count = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		
		/*logger.info("Finding all people!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}*/
		return repository.findAll();
		
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		
		/*Person person = new Person();
		person.setId(count.incrementAndGet());
		person.setFirstName("Julliano");
		person.setLastName("Moreira");
		person.setAddress("Eldorado do Sul - Rio Grande do Sul - Brasil");
		person.setGender("Male");*/
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
	}
	
	public Person create(Person person) {
		logger.info("Create one Person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person!");
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one Person!");
		
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(person);
		//return person;
	}
	
	/*private Person mockPerson(int i) {
		++i;
		Person person = new Person();
		//person.setId(count.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}*/
}
