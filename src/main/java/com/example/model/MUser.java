package com.example.model;

import java.util.List;

import lombok.Data;

@Data
public class MUser {
	private int id;
	private String name;
	private String email;
	private String password;
	private String introduction;
	private List<Book> bookList;
}
