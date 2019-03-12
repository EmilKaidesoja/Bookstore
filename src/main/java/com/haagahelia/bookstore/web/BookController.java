package com.haagahelia.bookstore.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.haagahelia.bookstore.domain.*;



@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String GetBooklist(Model model) {
		model.addAttribute("booklist", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value= "/addbook")
	public String AddBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value= "/save", method=RequestMethod.POST)
	public String SaveBook(Book book) {
		brepository.save(book);
		return "redirect:/booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String DeleteBook(@PathVariable("id")Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String EditBook(@PathVariable("id")Long bookId, Model model) {
		model.addAttribute("book", brepository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
	return "editBook";
}
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> GetBooksRest() {
		return (List<Book>) brepository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Book> GetBookByIdRest(@PathVariable("id") Long bookId){
		return brepository.findById(bookId);
	}
	
	
	
}
