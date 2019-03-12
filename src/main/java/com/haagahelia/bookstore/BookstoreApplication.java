package com.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagahelia.bookstore.domain.*;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args)-> {
			log.info("Save a couple of books");
			crepository.save(new Category("Education"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("non-fiction"));
			
			brepository.save(new Book("01010101-01", "Java master", "Learn Java", 2015, 24, crepository.findByName("Education").get(0)));
			brepository.save(new Book("02020202-02", "SQL master", "Learn SQL", 2010, 19, crepository.findByName("Education").get(0)));
			
			// Create users: admin/password: admin, user/password: user
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@bookstore.com", "ADMIN");
			User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com" , "USER");
			urepository.save(admin);
			urepository.save(user);
			
			log.info("fetch all books");
			for(Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

