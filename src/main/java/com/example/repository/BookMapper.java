package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.example.model.Book;

@Mapper
public interface BookMapper {
	@Options(useGeneratedKeys=true, keyColumn="id")
	public int insert(Book book);
	public List<Book> index();
	public Book show(int id);
	public void update(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	public int delete(@Param("id") int id);
}
