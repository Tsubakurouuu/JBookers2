package com.example.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String getTop() {
		return "home/top";
	}
	
	@GetMapping("/home/about")
	public String getAbout() {
		return "home/about";
	}
}
