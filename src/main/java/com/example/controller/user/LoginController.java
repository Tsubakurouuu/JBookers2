package com.example.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {
	@GetMapping("/sign_in")
	public String getLogin() {
		return "user/login";
	}
	
	@PostMapping("/sign_in")
	public String postLogin() {
		return "redirect:/users";
	}
}
