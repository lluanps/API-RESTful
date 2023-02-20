package br.com.luan.services;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luan.data.vo.v1.PersonVO;
import br.com.luan.exceptions.ResourceNotFoundException;
import br.com.luan.repositories.PersonRepository;

@Service
public class PersonService {

	
	private Logger logger = Logger.getLogger(PersonService.class.getName()); 
	
	@Autowired
	private PersonRepository repository;

	public List<PersonVO> findAll() {
		
		logger.info("Finding all people");
		
		return repository.findAll();
	}

	public PersonVO findById(Long id) {
		
		logger.info("Finding one person");
				
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id " + id));
	}
	
	public PersonVO create(PersonVO person) {
		
		logger.info("Creating one person");
		return repository.save(person);
	}
	
	public PersonVO update(PersonVO person) {
		
		logger.info("Updating one person");
		
		PersonVO entity = repository.findById(person.getId()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person");
		
		PersonVO entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		repository.delete(entity);
	}

}