package app.ecommerce.brand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ecommerce.brand.model.Brand;
import app.ecommerce.brand.service.BrandService;

@RestController
@RequestMapping("Brand")
public class BarndController {

	@Autowired
	BrandService brandservice;
	@RequestMapping("sample")
	public String sample() {
		return "Hiii it is working properly";
	}
	@PostMapping("/SaveBrand")
	public String saveBrand(@RequestBody Brand brand) {
		return brandservice.save(brand);
	}
	@GetMapping("/GetAll")
	public List<Brand> getAll(){
	return brandservice.getAll();
	}
	@GetMapping("/getbyname/{name}")
	public List<Brand> findByName(@PathVariable String name){
		return brandservice.findByName(name);
	}
	@DeleteMapping("/DeleteBrand/{id}")
	public String deleteBrand(@PathVariable int id){
		return brandservice.deleteBrand(id);
	}
	@PutMapping("/UpdateMapping")
	public String updateBrand(@RequestBody Brand brand) {
		return brandservice.updateMapping(brand);
		
	}
}
