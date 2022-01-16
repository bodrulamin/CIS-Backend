package com.cis.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cis.model.ApiResponse;
import com.cis.model.Subscription;
import com.cis.model.Status;
import com.cis.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/add")
	public ApiResponse addSubscription(@RequestBody Subscription subscription) throws Exception {
		res.getData().put("subscription", subscription);

		try {
			subscriptionService.save(subscription);
			res.setMsg("Subscription aded Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Subscription already exists");
			} else {
				res.setMsg("Failed to add subscription");
			}

		}
		return res;

	}

	

	@PostMapping("/update")
	public ApiResponse update(@RequestBody Subscription subscription) throws Exception {
		res.getData().put("subscription", subscription);

		try {
			subscriptionService.save(subscription);
			res.setMsg("Subscription updated Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Subscription already exists");
			} else {
				res.setMsg("Failed to add subscription");
			}

		}
		return res;

	}
	
	
	@PostMapping("/delete")
	public ApiResponse deleteSubscription(@RequestBody Subscription subscription) throws Exception {

		try {
			subscriptionService.delete(subscription);
			res.setMsg("Subscription Deleted Successfuly !");
			res.getData().put("subscription", subscription);
			res.setStatus(Status.success);
		}  catch (Exception e) {
			res.getData().put("subscription", subscription);
			res.setMsg(" failed to delete subscription !");
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getOne/{id}")
	public ApiResponse getOne(@PathVariable(value = "id") long id) throws Exception {

		try {
		Subscription subscription =  subscriptionService.findById(id).get();
			res.setMsg("All categories loaded Successfuly !");
			res.getData().put("subscription", subscription);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("subscription", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getAll")
	public ApiResponse getAll() throws Exception {

		try {
		List<Subscription> cats =	(List<Subscription>) subscriptionService.findAll();
			res.setMsg("All categories loaded Successfuly !");
			res.getData().put("subscription", cats);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("subscription", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	

}
