//package com.example.controller.book;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.example.form.BookEditForm;
//import com.example.form.GroupOrder;
//import com.example.model.Book;
//import com.example.model.MUser;
//import com.example.service.BookService;
//import com.example.service.impl.UserDetailsServiceImpl;
//
//public class BookEditController {
//	@Autowired
//	private BookService bookService;
//	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	@GetMapping("/books/{id}/edit")
//	public String getEdit(@ModelAttribute BookEditForm form, Model model, @PathVariable("id") int id, MUser loginUser) {
//		loginUser = userDetailsServiceImpl.getLoginUser();
//		Book book = bookService.show(id);
//		if(loginUser.getId() != book.getUserId()) {
//			return "redirect:/books/";
//		}
//		form = modelMapper.map(book, BookEditForm.class);
//		model.addAttribute("bookEditForm", form);
//		return "book/edit";
//	}
//	
//	@PostMapping("/books/update")
//	public String postUpdate(@ModelAttribute @Validated(GroupOrder.class) BookEditForm form, BindingResult bindingResult, Model model, int id, MUser loginUser, RedirectAttributes redirectAttributes) {
//		if(bindingResult.hasErrors()) {
//			return "book/edit";
//		}
//		bookService.update(form.getId(), form.getTitle(), form.getBody());
//		redirectAttributes.addFlashAttribute("complete", "You have updated book successfully.");
//		return "redirect:/books";
//	}
//	
//	@PostMapping("/books/delete")
//	public String postDelete(Model model, Book book) {
//		bookService.delete(book.getId());
//		return "redirect:/books";
//	}
//}
