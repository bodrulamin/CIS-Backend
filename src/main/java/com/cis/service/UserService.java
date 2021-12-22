package com.cis.service;

import org.springframework.data.repository.CrudRepository;

import com.cis.model.User;



public interface UserService extends CrudRepository<User, Long>{

}
