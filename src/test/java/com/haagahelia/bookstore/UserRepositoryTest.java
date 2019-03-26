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
public class UserRepositoryTest {
	
		@Autowired
		private UserRepository urepo;
		
		@Test
		public void findbyUsernameShouldReturnUser() {
			User user = urepo.findByUsername("user");
			assertThat(user.getUsername()).isEqualTo("user");
		}
		@Test
		public void createNewBook() {
			User user = new User("user3", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com" , "USER");
			urepo.save(user);
			assertThat(user.getId()).isNotNull();
		}
		
		@Test
		public void deleteUser() {
			User user = urepo.findByUsername("user");
			urepo.delete(user);
			User editedUser = urepo.findByUsername("user");
			assertThat(editedUser).isNull();
		}
	}
