package com.example.controller.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.GroupOrder;
import com.example.form.UserSignupForm;
import com.example.model.MUser;
import com.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@Slf4j
public class SignupController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/sign_up")
	public String getSignup(@ModelAttribute UserSignupForm form) {
		return "user/signup";
	}
	
	@PostMapping("/sign_up")
	public String postSignup(@ModelAttribute @Validated(GroupOrder.class) UserSignupForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "user/signup";
		}
		log.info(form.toString());
		MUser user = modelMapper.map(form, MUser.class);
		userService.signup(user);
		return "redirect:/users/sign_in";
	}
}
