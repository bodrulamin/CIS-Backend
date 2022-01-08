package com.cis.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.model.Category;
import com.cis.model.Shout;
 


@Repository
public interface ShoutService extends CrudRepository<Shout, Long>{

	

}
