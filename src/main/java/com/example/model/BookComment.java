package com.example.model;

import lombok.Data;

@Data
public class BookComment {
	private int id;
	private int userId;
	private int bookId;
	private String comment;
}
