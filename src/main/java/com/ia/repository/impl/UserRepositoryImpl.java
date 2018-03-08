package com.ia.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ia.entity.Person;
import com.ia.entity.User;
import com.ia.repository.PersonRepository;
import com.ia.repository.UserRepository;

import java.util.List;

/**
 * Created by XRog On 2/2/2017.2:30 PM
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public User load(Long id) {
		return (User) getCurrentSession().load(User.class, id);
	}

	public User get(Long id) {
		return (User) getCurrentSession().get(User.class, id);
	}

	public List<User> findAll() {
		return null;
	}

	public void persist(User entity) {
		getCurrentSession().persist(entity);
	}

	// AR1, can't insert entity to db.
	// Root cause-autocommit is set to false by default.
	// Need to set connection.autocommit to true in hibernate.cfg.xml
	public Long save(User entity) {
		Logger logger = Logger.getLogger(UserRepositoryImpl.class);
		logger.debug("entity is" + entity.getUsername() + " " + entity.getPassword() + " " + entity.getId());

		Session session = getCurrentSession();
		// Transaction transaction = session.beginTransaction();
		// transaction.begin();
		Long ret = (Long) session.save(entity);
		// session.flush();//or session.close();可以写，也可以不写
		// transaction.commit();

		return ret;
	}

	public void saveOrUpdate(User entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		User user = load(id);
		getCurrentSession().delete(user);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public User getByName(String name) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.openSession().createSQLQuery("select * from user where username='"+name+"'").addEntity(User.class);;
		List<User> users = query.list();
		if(users.size()==1){
			return users.get(0);
		}
		return null;
	}

}