package com.ia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.entity.User;
import com.ia.repository.UserRepository;
import com.ia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * (non-Javadoc)
	 * @see com.ia.service.UserService#saveUser()
	 * Save user to db
	 */
	@Override
	@Transactional
	public Long saveUser(User user) {
		//User user = new User();
	
		return userRepository.save(user);
	}

	/**
	 * User has been existed or not in DB.
	 */
	@Override
	public boolean isUserExist(User user) {
		User queryUser = userRepository.getByName(user.getUsername());
		if(queryUser == null){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean authenticate(User user) {
		User queryUser = userRepository.getByName(user.getUsername());
		if(queryUser != null && user.getPassword().equals(queryUser.getPassword())) {
			return true;
		}  
		return false;
	}
}
