package com.example.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Book;
import com.example.model.MUser;
import com.example.service.UserService;

@Controller
public class ShowController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{id}")
	public String getShow(Model model, @PathVariable("id") int id) {
		MUser user = userService.show(id);
		model.addAttribute("user", user);
		List<Book> bookList = user.getBookList();
		model.addAttribute("bookList", bookList);
		return "user/show";
	}
}
