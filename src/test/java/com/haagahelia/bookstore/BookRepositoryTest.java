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
public class BookRepositoryTest {

	@Autowired
	private BookRepository brepo;
	
	@Test
	public void findbyTitleShouldReturnBook() {
		List<Book> books = brepo.findByTitle("Learn Java");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Learn Java");
	}
	@Test
	public void createNewBook() {
		Book book = new Book("01010101-10", "C++ master", "Learn C++", 2019, 30, new Category("Fiction"));
		brepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	@Test
	public void deleteBook() {
		List <Book> books = brepo.findByTitle("Learn Java");
		brepo.delete(books.get(0));
		List <Book> editedbooks = brepo.findByTitle("Learn Java");
		assertThat(editedbooks).isEmpty();;
	}
}
