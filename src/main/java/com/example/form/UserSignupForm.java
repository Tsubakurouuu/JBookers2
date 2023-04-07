package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserSignupForm {
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 2, groups = ValidGroup2.class)
	private String name;
	
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup1.class)
	@Length(min = 6, groups = ValidGroup2.class)
	private String password;
}
