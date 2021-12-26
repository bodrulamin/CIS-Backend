package com.cis.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cis.model.Category;
import com.cis.model.User;
import com.cis.model.UserType;
 



public interface CategoryService extends CrudRepository<Category, Long>{

	@Query("UPDATE Category c set c.shoutcount = c.shoutcount + 1 WHERE c.id = :id")
	void incrementCategory(long id);

}
