package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookForm {
	private int userId;
	
	@NotBlank(groups = ValidGroup1.class)
	private String title;
	
	@NotBlank(groups = ValidGroup1.class)
	private String body;
}
