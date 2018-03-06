package com.ia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.common.ReturnMessage;
import com.ia.entity.User;
import com.ia.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(@RequestBody User user) {
		if(userService.isUserExist(user)){
	        System.out.println("A User with name "+user.getUsername()+" already exist");
	        return ReturnMessage.USER_EXIST.getMessage();
	    } 
		userService.saveUser(user);
		Logger logger = Logger.getLogger(UserController.class);
		logger.debug("Saved User: "+user.getUsername() + " " + user.getPassword());
		return ReturnMessage.USER_CREATED_SUCCESS.getMessage();
	}

}
