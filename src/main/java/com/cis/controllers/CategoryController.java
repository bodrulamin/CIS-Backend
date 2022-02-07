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
import com.cis.model.Category;
import com.cis.model.Status;
import com.cis.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(value = "*", maxAge = 3600)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	ApiResponse res = new ApiResponse();

	@PostMapping("/add")
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

	

	@PostMapping("/update")
	public ApiResponse update(@RequestBody Category category) throws Exception {
		res.getData().put("category", category);

		try {
			categoryService.save(category);
			res.setMsg("Category updated Successfuly !");
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
	
	
	@PostMapping("/delete")
	public ApiResponse deleteCategory(@RequestBody Category category) throws Exception {

		try {
			categoryService.delete(category);
			res.setMsg("Category Deleted Successfuly !");
			res.getData().put("category", category);
			res.setStatus(Status.success);
		}  catch (Exception e) {
			res.getData().put("category", category);
			res.setMsg(" failed to delete category !");
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getOne/{id}")
	public ApiResponse getOne(@PathVariable(value = "id") long id) throws Exception {

		try {
		Category category =  categoryService.findById(id).get();
			res.setMsg("All categories loaded Successfuly !");
			res.getData().put("category", category);
			res.setStatus(Status.success);
		}   catch (Exception e) {
			res.getData().put("category", null);
			res.setMsg(e.getMessage());
			res.setStatus(Status.failed);
		}

		return res;

	}
	
	@GetMapping("/getAll")
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
