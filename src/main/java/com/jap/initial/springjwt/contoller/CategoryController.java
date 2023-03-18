package com.jap.initial.springjwt.contoller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jap.initial.springjwt.entities.exam.Category;
import com.jap.initial.springjwt.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//category ekleme
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category caty = this.categoryService.addCategory(category);
		return ResponseEntity.ok(caty);
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllGategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category){
		return this.categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		this.categoryService.deletCategory(categoryId);
	}

}


