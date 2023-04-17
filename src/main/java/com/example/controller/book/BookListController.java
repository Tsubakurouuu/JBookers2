//package com.example.controller.book;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import com.example.form.BookForm;
//import com.example.model.Book;
//import com.example.model.MUser;
//import com.example.service.BookService;
//import com.example.service.impl.UserDetailsServiceImpl;
//
//public class BookListController {
//	@Autowired
//	private BookService bookService;
//	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
//	
//	@GetMapping("/books")
//	public String getIndex(@ModelAttribute BookForm bookForm, Model model, MUser loginUser) {
//		List<Book> bookList = bookService.index();
//		model.addAttribute("bookList", bookList);
//		loginUser = userDetailsServiceImpl.getLoginUser();
//		model.addAttribute("loginUser", loginUser);
//		return "book/index";
//	}
//}
