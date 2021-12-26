package com.cis.controllers;

 
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cis.model.ApiResponse;
import com.cis.model.Status;
import com.cis.model.User;
import com.cis.model.UserPayload;
import com.cis.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/signup")
	public ApiResponse sigup(@RequestBody User user) throws Exception  {
			res.getData().put("user", user);

		try {
			userService.save(user);
			res.setMsg("Signup Successfull !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			res.setMsg("Failed to Signup");
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Username already exists");
			} 

		}
		

		return res;

	}

	@PostMapping("/signin")
	public ApiResponse sigin(@RequestBody UserPayload payload) throws Exception {

		try {
			User user = userService.findByUsername(payload.getUsername(), payload.getUsertype());
			if (user == null)
				throw new Exception(payload.getUsername() + " user not found !");

			if (user.getPassword().equals(payload.getPassword())) {
				res.setMsg("SignIn Successfull !");
				res.getData().put("user", user);
				res.setStatus(Status.success);
			} else {
				res.getData().put("user", payload);
				res.setMsg("wrong password");
				res.setStatus(Status.failed);
			}

		} catch (Exception e) {

			res.getData().put("user", payload);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);

		}

		return res;

	}

}
