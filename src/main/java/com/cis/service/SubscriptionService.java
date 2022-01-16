package com.cis.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.model.Category;
import com.cis.model.Shout;
import com.cis.model.Subscription;
 


@Repository
public interface SubscriptionService extends CrudRepository<Subscription, Long>{

	

}
