package app.ecommerce.category.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.ecommerce.category.model.Category;
import app.ecommerce.category.service.CategoryService;


@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryservice;
	
	@GetMapping("/hiii")
	public String sample() {
		return "Working properly";
	}
	
	@PostMapping("Category/SaveCategory")
	public String saveCategory(@RequestBody Category category) {
		return categoryservice.saveCategory(category);
	}
	@DeleteMapping("Category/DeleteMapping/{id}")
	public String deleteMapping(@PathVariable int id) {
		return categoryservice.deleteCategory(id);
		 
	}
	@GetMapping("Category/GetAllCategory")
	public List<Category> getAllCategory(){
		return  categoryservice.getAllCategory();
	}
	@GetMapping("Category/GetCategory/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id) {
		return categoryservice.getCategoryById(id);
		
	}
	@GetMapping("Category/GetCategoryByName/{name}")
	public List<Category> getCategoryByName(@PathVariable String name){
		return categoryservice.findByName(name);
		 
	}
	@GetMapping("Category/GetCategoryByEnabled/{enabled}")
	public List<Category> getCategoryByEnable(@PathVariable boolean enabled){
		return categoryservice.findByEnabled(enabled);
		
	}
	
	@PutMapping("Category/UpdateCategory")
	public String updateCategory(@RequestBody Category category) {
		return categoryservice.updateCategory(category);
		
	}
	
	
}
