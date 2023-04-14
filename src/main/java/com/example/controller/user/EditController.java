package com.example.controller.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.GroupOrder;
import com.example.form.UserEditForm;
import com.example.model.MUser;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImpl;

@Controller
public class EditController {
	@Autowired
	private UserService userService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/users/{id}/edit")
	public String getEdit(@ModelAttribute UserEditForm form, Model model, @PathVariable("id") int id, MUser loginUser) {
		loginUser = userDetailsServiceImpl.getLoginUser();
		MUser user = userService.show(id);
		if(loginUser.getId() != user.getId()) {
			return "redirect:/users/" + loginUser.getId();
		}
		form = modelMapper.map(user, UserEditForm.class);
		model.addAttribute("userEditForm", form);
		return "user/edit";
	}
	
	@PostMapping("/users/update")
	public String postUpdate(@ModelAttribute @Validated(GroupOrder.class) UserEditForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "user/edit";
		}
		userService.update(form.getId(), form.getName(), form.getIntroduction());
		return "redirect:/users";
	}
}
