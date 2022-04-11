package app.ecommerce.brand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce.brand.exception.BrandALreadyExistsException;
import app.ecommerce.brand.exception.BrandNotFoundException;
import app.ecommerce.brand.model.Brand;
import app.ecommerce.brand.repository.BrandRepo;

@Service
public class BrandService {

	@Autowired
	BrandRepo brandrepo;
	
	public String save(Brand brand) {
		
		if(brandrepo.findById(brand.getId()).isPresent() || brandrepo.findByName(brand.getName()).isPresent()) {
			throw new BrandALreadyExistsException("Brand already exits in database you cannot add one Brand Again.");
		}
		brandrepo.save(brand);
		return "Saved sucessfully";	
	}
	
	public List<Brand> getAll(){

	return brandrepo.findAll();
	}
	
	public String deleteBrand(int id){
		if(brandrepo.findById(id).isEmpty()) {
			throw new BrandNotFoundException("Brand Not found in Database already deleted.");
		}
		brandrepo.deleteById(id);
		return "Deleted sucessfully";
	}
	
	public String updateMapping(Brand brand) {
		if(brandrepo.findById(brand.getId()).isEmpty()) {
			throw new BrandNotFoundException("Brand Not found in Database already deleted.");
		}
	Brand brand1 = brandrepo.getById(brand.getId());
		brand1.setName(brand.getName());
		brand1.setLogo(brand.getLogo());
		brand1.setCategoryid(brand.getCategoryid());
		brandrepo.save(brand1);
		return "Updated Sucessfully";
		}
	
	public List<Brand> findByName(String name){
		if(brandrepo.findByname(name).isEmpty()) {
			throw new BrandNotFoundException("Nothing found with the similar name in database try diiffernt name");
		}
	return brandrepo.findByname(name);
	}
}

