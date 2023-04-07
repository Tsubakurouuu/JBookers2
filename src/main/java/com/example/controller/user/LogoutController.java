package com.example.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogoutController {
	@PostMapping("/logout")
	public String postLogin() {
		log.info("ログアウト");
		return "redirect:/users/sign_in";
	}
}
