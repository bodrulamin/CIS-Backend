package com.cis.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.emitter.Emitable;

import com.cis.mail.EmailService;
import com.cis.model.ApiResponse;
import com.cis.model.Shout;
import com.cis.model.Status;
import com.cis.model.User;
import com.cis.model.UserType;
import com.cis.service.ShoutService;
import com.cis.service.UserService;

@RestController
@RequestMapping("/shout")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class ShoutController {

	


	@Autowired
	private ShoutService shoutService;
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/add")
	public ApiResponse addShout(@RequestBody Shout shout) throws Exception {
		res.getData().put("shout", shout);

		try {
			shoutService.save(shout);
			res.setMsg("Shout added Successfuly !");
			res.setStatus(Status.success);
			
			List<User> userstosendmail = userService.getAllUser(UserType.provider);
			
			String[] emails =   userstosendmail.
					stream()
					.map(u->u.getEmail())
					.toArray(String[]::new);
			for (String string : emails) {
				System.out.println(string);
			}
			
		 System.out.println(emails);
			emailService.sendSimpleMessage(
					emails
				,
			shout.getShoutTitle(), 
			shout.getShoutmessage());

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Shout already exists");
			} else {
				res.setMsg("Failed to add shout");
			}

		}
		return res;

	}

	

	@PostMapping("/update")
	public ApiResponse update(@RequestBody Shout shout) throws Exception {
		res.getData().put("shout", shout);

		try {
			shoutService.save(shout);
			res.setMsg("Shout updated Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Shout already exists");
			} else {
				res.setMsg("Failed to add shout");
			}

		}
		return res;

	}
	
	
	@PostMapping("/delete")
	public ApiResponse deleteShout(@RequestBody Shout shout) throws Exception {

		try {
			shoutService.delete(shout);
			res.setMsg("Shout Deleted Successfuly !");
			res.getData().put("shout", shout);
			res.setStatus(Status.success);
		}  catch (Exception e) {
			res.getData().put("shout", shout);
			res.setMsg(" failed to delete shout !");
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getOne/{id}")
	public ApiResponse getOne(@PathVariable(value = "id") long id) throws Exception {

		try {
		Shout shout =  shoutService.findById(id).get();
			res.setMsg("All shouts loaded Successfuly !");
			res.getData().put("shout", shout);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("shout", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getAll")
	public ApiResponse getAll() throws Exception {

		try {
		List<Shout> cats =	(List<Shout>) shoutService.findAll();
			res.setMsg("All shouts loaded Successfuly !");
			res.getData().put("shout", cats);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("shout", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}

	
}
