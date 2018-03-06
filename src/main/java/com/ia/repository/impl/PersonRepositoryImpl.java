package com.ia.repository.impl;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ia.entity.Person;
import com.ia.repository.PersonRepository;

import java.util.List;

/**
 * Created by XRog
 * On 2/2/2017.2:30 PM
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Person load(Long id) {
        return (Person)getCurrentSession().load(Person.class,id);
    }

    public Person get(Long id) {
        return (Person)getCurrentSession().get(Person.class,id);
    }

    public List<Person> findAll() {
        return null;
    }

    public void persist(Person entity) {
        getCurrentSession().persist(entity);
    }

    //AR1, can't insert entity to db.
    //Root cause-autocommit is set to false by default. 
    //Need to set connection.autocommit to true in hibernate.cfg.xml
    public Long save(Person entity) {
    	Logger logger  =  Logger.getLogger(PersonRepositoryImpl.class);
        logger.debug("entity is" +entity.getAddress()+ " "+ entity.getCreated()+ " "+entity.getId());
        
        Session  session = getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        //transaction.begin();
        Long ret = (Long)session.save(entity);
        //session.flush();//or session.close();可以写，也可以不写
        //transaction.commit();
        
        return ret;
    }

    public void saveOrUpdate(Person entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        Person person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();
    }


}