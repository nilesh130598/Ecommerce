package app.ecommerce.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce.category.exception.CategoryNotFoundException;
import app.ecommerce.category.exception.EnterProperFieldsException;
import app.ecommerce.category.model.Category;
import app.ecommerce.category.repository.CategoryRepo;



@Service
public class CategoryService {
 @Autowired
 CategoryRepo categoryrepo;

	
 public String saveCategory(Category category) {
	 if(category.getId()<=0) {
		 throw new EnterProperFieldsException("Id Cannot be negative");
	 }
	 if(category.getName().isEmpty() || category.getImage().isBlank()) {
		 throw new EnterProperFieldsException("Fileds can not be empty");
	 }
	 categoryrepo.save(category);
	 return "Category Saved Sucessfully";
 }
 
 public String deleteCategory(int id) {
	 if(categoryrepo.findById(id).isEmpty()) {
		 throw new CategoryNotFoundException("Catgeory Not Found in Database");
	 }
	 categoryrepo.deleteById(id);
	 return "Category Deleted Sucessfully";
 }
 
 public Optional<Category> getCategoryById(int id) {
	 Optional<Category> catt = categoryrepo.findById(id);
	 if(catt.isEmpty()) {
		 throw new CategoryNotFoundException("Catgeory Not Found in Database");
	 }
	 return catt;
 }
 
 public String updateCategory(Category category) {
	 if(categoryrepo.findById(category.getId()).isEmpty()) {
		 throw new CategoryNotFoundException("given category not found in database so you cant update it.");
	 }
     Category cat= categoryrepo.getById(category.getId());
     cat.setName(category.getName());
     cat.setImage(category.getImage());
     cat.setEnabled(category.isEnabled());
     cat.setParentid(category.getParentid());
     categoryrepo.save(cat);
	 return "Catgeory updated sucessfully";
 }
 
 public List<Category> findByName(String name) {
	 List<Category> list = categoryrepo.findByname(name);
	 if(list.isEmpty()) {
		 throw new CategoryNotFoundException("Category related to this name not found in the database");
	 }
	 return list;
 }
 public List<Category> findByEnabled(boolean enabled){
	 return categoryrepo.findByEnabled(enabled);

 }
 public List<Category> getAllCategory(){
	 return categoryrepo.findAll(); 
 }
}
