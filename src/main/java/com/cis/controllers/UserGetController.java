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
import com.cis.model.User;
import com.cis.model.Status;
import com.cis.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class UserGetController {

	@Autowired
	private UserService userService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/add")
	public ApiResponse addCategory(@RequestBody User user) throws Exception {
		res.getData().put("user", user);

		try {
			userService.save(user);
			res.setMsg("User aded Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("User already exists");
			} else {
				res.setMsg("Failed to add user");
			}

		}
		return res;

	}

	

	@PostMapping("/update")
	public ApiResponse update(@RequestBody User user) throws Exception {
		res.getData().put("user", user);

		try {
			userService.save(user);
			res.setMsg("User updated Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("User already exists");
			} else {
				res.setMsg("Failed to add user");
			}

		}
		return res;

	}
	
	
	@PostMapping("/delete")
	public ApiResponse deleteCategory(@RequestBody User user) throws Exception {

		try {
			userService.delete(user);
			res.setMsg("User Deleted Successfuly !");
			res.getData().put("user", user);
			res.setStatus(Status.success);
		}  catch (Exception e) {
			res.getData().put("user", user);
			res.setMsg(" failed to delete user !");
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getOne/{id}")
	public ApiResponse getOne(@PathVariable(value = "id") long id) throws Exception {

		try {
		User user =  userService.findById(id).get();
			res.setMsg("All users loaded Successfuly !");
			res.getData().put("user", user);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("user", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getAll")
	public ApiResponse getAll() throws Exception {

		try {
		List<User> cats =	(List<User>) userService.findAll();
			res.setMsg("All users loaded Successfuly !");
			res.getData().put("user", cats);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("user", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	

}
