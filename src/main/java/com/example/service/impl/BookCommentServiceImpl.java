package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BookComment;
import com.example.repository.BookCommentMapper;
import com.example.service.BookCommentService;
@Service
public class BookCommentServiceImpl implements BookCommentService {
	@Autowired
	private BookCommentMapper mapper;
	
	@Override
	public void insert_comment(BookComment book_comment) {
		mapper.insert_comment(book_comment);
	}

}
