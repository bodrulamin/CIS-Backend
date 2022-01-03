package com.cis.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.model.Category;
 


@Repository
public interface CategoryService extends CrudRepository<Category, Long>{

	

}
