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
		}catch (Exception e) {
			
		res.getData().put("user", user);
		res.setMsg(e.getMessage());
		res.setStatus(Status.failed);

		}
		
		return res;
		
	}

}
