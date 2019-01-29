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
	public CommandLineRunner Demo(BookRepository repository) {
		return (args)-> {
			log.info("Save a couple of books");
			repository.save(new Book("01010101-01", "Java master", "Learn Java", 2015, 24));
			repository.save(new Book("02020202-02", "SQL master", "Learn SQL", 2010, 19));
			
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

