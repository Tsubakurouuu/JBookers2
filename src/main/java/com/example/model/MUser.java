package com.example.model;

import lombok.Data;

@Data
public class MUser {
	private int id;
	private String name;
	private String email;
	private String password;
	private String introduction;
}
