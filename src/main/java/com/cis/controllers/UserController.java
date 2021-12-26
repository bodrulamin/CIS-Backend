package com.cis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ApiResponse sigup(@RequestBody User user) throws Exception {
		
		
		
		try {
			userService.save(user);
			res.setMsg("Signup Successfull !");
	 		res.getData().put("user", user);
			res.setStatus(Status.success);
		} catch (Exception e) {
			
		res.getData().put("user", user);
		res.setMsg(e.getMessage());
		res.setStatus(Status.failed);

		}
		
		return res;
		
	}

	
	
	@PostMapping("/signin")
	public ApiResponse sigin(@RequestBody UserPayload payload) throws Exception {
		
		try {
			User user = userService.findByUsername(payload.getUsername());
			if(user==null) throw new Exception(payload.getUsername() + " user not found !");
			res.setMsg("SignIn Successfull !");
	 		res.getData().put("user", user);
			res.setStatus(Status.success);
		}catch (Exception e) {
			
		res.getData().put("user", payload);
		res.setMsg(e.getMessage());
		res.setStatus(Status.failed);

		}
		
		return res;
		
	}

	
	
	
}
