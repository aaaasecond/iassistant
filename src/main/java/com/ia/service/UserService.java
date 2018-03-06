package com.ia.service;

import com.ia.entity.User;

public interface UserService {
	Long saveUser(User user);

	boolean isUserExist(User user);
}
