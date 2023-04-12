package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repository.BookMapper;
import com.example.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private BookMapper mapper;

	@Override
	public void insert(Book book) {
//		MUser loginUser = userDetailsServiceImpl.getLoginUser();
//		book.setUserId(loginUser.getId());
		mapper.insert(book);
	}

	@Override
	public List<Book> index() {
		return mapper.index();
	}

	@Override
	public Book show(int id) {
		return mapper.show(id);
	}

	@Override
	public void update(int id, String title, String body) {
		mapper.update(id, title, body);
	}

	@Override
	public void delete(int id) {
		mapper.delete(id);
	}

	
	

}
