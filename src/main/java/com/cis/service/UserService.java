package com.cis.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cis.model.User;
import com.cis.model.UserType;



public interface UserService extends CrudRepository<User, Long>{

	@Query("select u from User u where u.username = ?1 and usertype = ?2")
	User findByUsername(String username, UserType userType);
	
	
}
