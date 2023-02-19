package br.com.luan.services;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.luan.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonService.class.getName()); 

	public List<Person> findAll() {
		
		logger.info("Finding all people");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

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
	
	
	private Person mockPerson(int i) {
		
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name: " + i);
		person.setLastName("Last name: " + i );
		person.setAddress("Some address in Brazil " + i);
		person.setGender("Male");
		
		return person;
	}
	
}