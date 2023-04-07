package com.example.controller.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.UserEditForm;
import com.example.model.MUser;
import com.example.service.UserService;

@Controller
public class EditController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/users/{id}/edit")
	public String getEdit(UserEditForm form, Model model, @PathVariable("id") int id) {
		MUser user = userService.show(id);
		form = modelMapper.map(user, UserEditForm.class);
		model.addAttribute("editForm", form);
		return "user/edit";
	}
	
	@PostMapping("/users/update")
	public String postUpdate(UserEditForm form, Model model) {
		userService.update(form.getId(), form.getName(), form.getIntroduction());
		return "redirect:/users";
	}
}
