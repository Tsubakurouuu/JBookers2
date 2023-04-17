package com.example.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MUser;

@Controller
@RequestMapping("/users")
public class UserLoginController {
	@GetMapping("/sign_in")
	public String getLogin() {
		return "user/login";
	}
	
	@PostMapping("/sign_in")
	public String postLogin(@AuthenticationPrincipal MUser loginUser) {
		return "redirect:/users/" + loginUser.getId();
	}
}
