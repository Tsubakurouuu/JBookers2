package com.example.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.form.BookForm;
import com.example.model.Book;
import com.example.model.MUser;
import com.example.service.BookService;
import com.example.service.impl.UserDetailsServiceImpl;

@Controller
public class BookShowController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/books/{id}")
	public String getShow(Model model, @PathVariable("id") int id, @ModelAttribute BookForm bookForm, MUser loginUser) {
		Book book = bookService.show(id);
		model.addAttribute("book", book);
		loginUser = userDetailsServiceImpl.getLoginUser();
		model.addAttribute("loginUser", loginUser);
		return "book/show";
	}
	
}
