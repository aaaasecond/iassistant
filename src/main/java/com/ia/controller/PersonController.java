package com.ia.controller;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.core.Logger;

//import java.util.logging.Logger;

//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.entity.Person;
import com.ia.service.PersonService;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson(){
        personService.savePerson();
        Logger logger  =  Logger.getLogger(PersonController.class);
        logger.debug("test log4j");
        return "success!";
    }
}