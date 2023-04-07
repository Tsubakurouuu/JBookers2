package com.example.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.MUser;
import com.example.service.UserService;

@Controller
public class ListController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<MUser> userList = userService.index();
		model.addAttribute("userList", userList);
		return "user/index";
	}
}
