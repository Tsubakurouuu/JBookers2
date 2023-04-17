package com.example.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.form.BookForm;
import com.example.model.MUser;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImpl;

@Controller
public class UserListController {
	@Autowired
	private UserService userService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/users")
	public String getUsers(Model model, @ModelAttribute BookForm bookForm, MUser loginUser) {
		List<MUser> userList = userService.index();
		model.addAttribute("userList", userList);
		loginUser = userDetailsServiceImpl.getLoginUser();
		model.addAttribute("loginUser", loginUser);
		return "user/index";
	}
}
