package com.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haagahelia.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

	@Autowired
	private BookController controller;
	
	@Test
	public void controllerIsPresent() throws Exception {
		assertThat(controller).isNotNull();
	}
}
