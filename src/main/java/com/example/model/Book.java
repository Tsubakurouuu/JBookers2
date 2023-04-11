package com.example.model;

import lombok.Data;

@Data
public class Book {
	private int id;
	private int userId;
	private String title;
	private String body;
	private MUser mUser;
}
