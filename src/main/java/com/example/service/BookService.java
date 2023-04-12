package com.example.service;

import java.util.List;

import com.example.model.Book;

public interface BookService {
	public void insert(Book book);
	public List<Book> index();
	public Book show(int id);
	public void update(int id, String title, String body);
	public void delete(int id);
}
