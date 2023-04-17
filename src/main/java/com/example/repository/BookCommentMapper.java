package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.BookComment;

@Mapper
public interface BookCommentMapper {
	public int insert_comment(BookComment book_comment);
}
