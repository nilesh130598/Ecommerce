package app.ecommerce.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.ecommerce.category.model.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

List<Category> findByname(String name);

List<Category> findByEnabled(boolean enabled);
}
