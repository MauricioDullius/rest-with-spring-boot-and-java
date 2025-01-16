package com.md.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.data.vo.v1.PersonVO;
import com.md.exceptions.ResourceNotFoundException;
import com.md.mapper.DozerMapper;
import com.md.model.Person;
import com.md.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	
	public PersonVO create(PersonVO person)
	{
		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person)
	{
		logger.info("Updating one person!");

		var entity = repository.findById(person.getId())
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public void delete(Long id)
	{
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all people!");
		
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);	
	}
}
