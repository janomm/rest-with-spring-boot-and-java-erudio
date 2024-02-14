package br.com.erudio.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	private final AtomicLong count = new AtomicLong();
	
	@Autowired
	private   PersonServices service;
	//private PersonServices service = new PersonServices();
	
	//private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		//logger.info("Aqui");
		//logger.info(service.findAll());
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id ) {
		return service.findById(id);
	}

	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person create(@RequestBody Person person ) {
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person update(@RequestBody Person person ) {
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id ) {
		service.delete(id);
	}
 
}