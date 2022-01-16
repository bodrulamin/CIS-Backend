package com.cis.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.model.Shout;
 


@Repository
public interface ShoutService extends CrudRepository<Shout, Long>{
	
	@Query("select s from Shout s where s.shouterId = ?1")
	public List<Shout> getShoutsOfShouter(long shouterId);

	@Query("select s from Shout s where s.categoryId in (select sub.categoryId From Subscription sub where sub.actionTakerId = ?1) ")
	public List<Shout> getShoutsOfProvider(long providerId);
	

}
