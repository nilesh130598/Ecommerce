package app.ecommerce.Category;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import app.ecommerce.category.model.Category;
import app.ecommerce.category.repository.CategoryRepo;
import app.ecommerce.category.service.CategoryService;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@InjectMocks
	CategoryService categoryservice;
	@Mock
	CategoryRepo categoryrepo;
	
	public Category sample1() {
		Category cat = new Category();
		cat.setId(1);
		cat.setName("nilesh");
		cat.setImage("nilesh");
		cat.setEnabled(true);
		cat.setParentid(1);
		return cat;
	}
	@Test
	public void testSaveCategory() {
		when(categoryrepo.save(sample1())).thenReturn(sample1());
		assertEquals(categoryservice.saveCategory(sample1()),"Category Saved Sucessfully" );
	}
	
	@Test
	public void testDeleteCategory() {
		List<Category> list = new ArrayList<>();
		list.add(sample1());
		Optional<Category> optional = list.stream().findAny();
		when(categoryrepo.findById(1)).thenReturn(optional);
		assertEquals(categoryservice.deleteCategory(1), "Category Deleted Sucessfully");
		}
	
	@Test
	public void testGetCategorybyId() {
		
	}

}
