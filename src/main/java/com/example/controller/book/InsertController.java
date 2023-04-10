package com.example.controller.book;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.BookForm;
import com.example.model.Book;
import com.example.model.MUser;
import com.example.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InsertController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/books")
	public String getIndex(@ModelAttribute BookForm bookForm, Model model) {
		List<Book> bookList = bookService.index();
		model.addAttribute("bookList", bookList);
		return "book/index";
	}
	
	@PostMapping("/books/insert")
	public String postInsert(@ModelAttribute BookForm form, @AuthenticationPrincipal MUser loginUser) {
		Book book = modelMapper.map(form, Book.class);
//		book.setUserId(loginUser.getId());
		bookService.insert(book);
		log.info(form.toString());
		return "redirect:/users";
	}
	
	@GetMapping("/books/{id}")
	public String getSHow(Model model, @PathVariable("id") int id) {
		Book book = bookService.show(id);
		model.addAttribute("book", book);
		return "book/show";
	}
	
}
