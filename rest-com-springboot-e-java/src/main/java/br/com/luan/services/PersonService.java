package br.com.luan.services;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.luan.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName()); 

	public Person findById(String id) {
		
		logger.info("Finding one person");
		
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Luan");
		person.setLastName("Pinheiro");
		person.setAddress("Biguacu - Santa Catarina - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
}