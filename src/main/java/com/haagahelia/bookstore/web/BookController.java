package com.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.haagahelia.bookstore.domain.Book;
import com.haagahelia.bookstore.domain.BookRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String GetBooklist(Model model) {
		model.addAttribute("booklist", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value= "/addbook")
	public String AddBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	@RequestMapping(value= "/save", method=RequestMethod.POST)
	public String SaveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String DeleteBook(@PathVariable("id")Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
}
