package com.example.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.BookForm;
import com.example.model.MUser;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImpl;

@Controller
public class ShowController {
	@Autowired
	private UserService userService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/users/{id}")
	public String getShow(Model model, @PathVariable("id") int id, @ModelAttribute BookForm bookForm) {
		MUser user = userService.show(id);
		model.addAttribute("user", user);
		return "user/show";
	}
	
	@PostMapping("/users/my_page")
	public String postMyPage(MUser loginUser, Model model) {
		loginUser = userDetailsServiceImpl.getLoginUser();
		model.addAttribute("loginUser", loginUser);
		return "redirect:/users/" + loginUser.getId();
	}
}
