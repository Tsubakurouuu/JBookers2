package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserEditForm {
	private int id;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 2, groups = ValidGroup2.class)
	private String name;
	private String introduction;
}
