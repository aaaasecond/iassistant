package com.ia.repository;

import com.ia.entity.User;

public interface UserRepository extends DomainRepository<User,Long>{
	
	 User getByName(String name);

}
