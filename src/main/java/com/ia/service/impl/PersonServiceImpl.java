package com.ia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.entity.Person;
import com.ia.repository.PersonRepository;
import com.ia.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Long savePerson() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setUsername("testuser");
		person.setPhone("123456");
		person.setAddress("shanghai");
		person.setRemark("this is test user");
		return personRepository.save(person);
	}

}
