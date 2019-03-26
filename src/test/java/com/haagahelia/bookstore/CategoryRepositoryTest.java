package com.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haagahelia.bookstore.domain.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepo;
	
	@Test
	public void findByCategoryNameShouldReturnCategory() {
		List<Category> categories = crepo.findByName("Education");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Education");
	}
	@Test
	public void createNewCategory() {
		Category category = new Category("Entertainment");
		crepo.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	@Test
	public void deleteCategory() {
		List <Category> categories = crepo.findByName("Education");
		crepo.delete(categories.get(0));
		List <Category> editedCategories = crepo.findByName("Education");
		assertThat(editedCategories).isEmpty();;
	}
}
