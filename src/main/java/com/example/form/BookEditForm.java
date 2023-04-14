package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookEditForm {
	private int id;
	
	@NotBlank(groups = ValidGroup1.class)
	private String title;
	
	@NotBlank(groups = ValidGroup1.class)
	private String body;
}
