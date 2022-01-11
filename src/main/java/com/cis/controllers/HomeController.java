package com.cis.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cis.model.Ruser;
import com.cis.model.User;

@RestController
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class HomeController {
	
	@GetMapping("/")
	public String sigup() {
		

		return "hello world";
		
	}
	
	@PostMapping("/test")
	public String tests(@RequestBody Ruser usr) {
		
		System.out.println(usr.getFullname());
		

		return "hello world";
		
	}

}
