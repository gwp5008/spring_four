package com.spring.four.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.four.dao.BookDAO;
import com.spring.four.dao.SubjectDAO;
import com.spring.four.model.Book;
import com.spring.four.model.Subject;



@Controller
@Transactional
public class BookController {

	@Autowired
	private SubjectDAO subjectDAO;

	@Autowired
	private BookDAO bookDAO;

	private Book book;
	
	private Subject subject;

	public BookController() {

	}
	
	@GetMapping("/mainPage")
	public String returnHome() {
		return "main-menu";
	}

	@GetMapping("/addBookPage")
	public String toAddBookPage() {
		return "add-book-form";
	}

	@GetMapping("/deleteBookPage")
	public String toDeleteBookPage() {
		return "delete-book-form";
	}

	@GetMapping("/searchBooksPage")
	public String toSearchBooksPage() {
		return "search-books-form";
	}
	@GetMapping("/deleteBook")
	public String deleteBook(HttpServletRequest request, Model model) {
		bookDAO.delete(Long.parseLong(request.getParameter("deleteBookID")));
		return "delete-book-success";
	}
	
	@GetMapping("/searchBooks")
	public String searchForBook(HttpServletRequest request, Model model) {
		String message = "";
		
		String bookId = request.getParameter("bookId");
		book = bookDAO.find(Long.parseLong(bookId));
		
		if (book != null && book.getActive() != 0) {
			message = "Your book was found.";
		}
		else {
			message = "Your book was not found.";
		}
		model.addAttribute("sBMessage", message);
		
		return "search-books-completed";
	}

	@PostMapping("/addBook")
	public String setBookInfo(HttpServletRequest request, Model model) {
		book = new Book();

		String title = request.getParameter("bookTitle");
		Double price = Double.parseDouble(request.getParameter("bookPrice"));
		int volume = Integer.parseInt(request.getParameter("bookVolume"));
		String date = request.getParameter("bookPublishDate");
		String ourSubject = request.getParameter("bookSubject");

		subject = subjectDAO.checkMatchingSubject(ourSubject);

		if (subject != null) {
			book.setTitle(title);
			book.setPrice(price);
			book.setVolume(volume);
			book.setActive(1);
			book.setPublishDate(date);
			book.setSubject(subject);
		}
		else {
			book.setTitle(title);
			book.setPrice(price);
			book.setActive(1);
			book.setVolume(volume);
			book.setPublishDate(date);
		}
		
		bookDAO.save(book);

		return "add-book-success";
	}
}
