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
	public CommandLineRunner Demo(BookRepository brepository, CategoryRepository crepository) {
		return (args)-> {
			log.info("Save a couple of books");
			crepository.save(new Category("Education"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("non-fiction"));
			
			brepository.save(new Book("01010101-01", "Java master", "Learn Java", 2015, 24, crepository.findByName("Education").get(0)));
			brepository.save(new Book("02020202-02", "SQL master", "Learn SQL", 2010, 19, crepository.findByName("Education").get(0)));
			
			log.info("fetch all books");
			for(Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

