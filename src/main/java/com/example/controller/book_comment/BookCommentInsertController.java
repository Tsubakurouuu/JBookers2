package com.example.controller.book_comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.BookCommentForm;
import com.example.model.Book;
import com.example.model.BookComment;
import com.example.model.MUser;
import com.example.service.BookCommentService;
import com.example.service.BookService;
import com.example.service.impl.UserDetailsServiceImpl;

@Controller
public class BookCommentInsertController {
	@Autowired
	private BookCommentService bookCommentService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@PostMapping("/book_comment/insert")
	public String postInsert(@ModelAttribute BookCommentForm bookCommentForm, int id, MUser loginUser) {
		loginUser = userDetailsServiceImpl.getLoginUser();
		Book bookId = bookService.show(id);
		BookComment bookComment = new BookComment();
		bookComment.setUserId(loginUser.getId());
		bookComment.setBookId(bookId.getId());
		bookComment.setComment(bookCommentForm.getComment());
		bookCommentService.insert_comment(bookComment);
		return "redirect/books";
	}
	
}
