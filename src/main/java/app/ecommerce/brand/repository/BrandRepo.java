package app.ecommerce.brand.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.ecommerce.brand.model.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {

	List<Brand> findByname(String name);
	Optional<Brand> findByName(String b);
}
