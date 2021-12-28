package com.cis.controllers;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cis.model.ApiResponse;
import com.cis.model.Category;
import com.cis.model.Status;
import com.cis.service.CategoryService;

@RestController
@CrossOrigin(value = "http://localhost:4200" ,maxAge = 3600)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/addcat")
	public ApiResponse addCategory(@RequestBody Category category) throws Exception {
		res.getData().put("category", category);

		try {
			categoryService.save(category);
			res.setMsg("Category aded Successfuly !");
			res.setStatus(Status.success);

		} catch (Exception ex) {
			res.setStatus(Status.failed);
			if (ex.getCause() instanceof ConstraintViolationException) {
				res.setMsg("Category already exists");
			} else {
				res.setMsg("Failed to add category");
			}

		}
		return res;

	}

	@PostMapping("/delcategory")
	public ApiResponse deleteCategory(@RequestBody Category category) throws Exception {

		try {
			categoryService.save(category);
			res.setMsg("Category aded Successfuly !");
			res.getData().put("category", category);
			res.setStatus(Status.success);
		} catch (ConstraintViolationException e) {
			throw new Exception("Category already exists !");

		} catch (Exception e) {
			res.getData().put("category", category);
			res.setMsg("Category already exists !");
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getAllCategories")
	public ApiResponse getAll() throws Exception {

		try {
		List<Category> cats =	(List<Category>) categoryService.findAll();
			res.setMsg("All categories loaded Successfuly !");
			res.getData().put("category", cats);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("category", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	

}
