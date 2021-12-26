package com.cis.controllers;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cis.model.ApiResponse;
import com.cis.model.Category;
import com.cis.model.Status;
import com.cis.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/addcategory")
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

}
