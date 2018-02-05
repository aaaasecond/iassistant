package com.ia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.entity.Person;
import com.ia.repository.PersonRepository;
import com.ia.service.PersonService;

@Service

public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional
	public Long savePerson() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setUsername("testuser");
		person.setPhone("123456");
		person.setAddress("shanghai");
		person.setRemark("this is test user");
		person.setCreated(new Long(100));
//		person.setId(new Long(1));
	
		return personRepository.save(person);
	}

}
