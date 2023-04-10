package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Book;

@Mapper
public interface BookMapper {
	public int insert(Book book);
	public List<Book> index();
	public Book show(int id);
}
