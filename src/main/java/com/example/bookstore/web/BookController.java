package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String GetBook(Model model) {	
		return "Book";
	}
}
