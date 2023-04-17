package com.example.form;

import lombok.Data;

@Data
public class BookCommentForm {
	private int userId;
	private int bookId;
	private String comment;
}
