package com.nagarro.trainingAssignments.Assignment5Boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.Book;
import com.nagarro.trainingAssignments.Assignment5Boot.service.BookService;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/allbooks")
	public List<Book> getAllBooks() {
		return bookService.listAllBooks();
	}

	@GetMapping("/getbook/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}

	@PostMapping("/update")
	public String updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

	@PostMapping("/addbook")
	public String addBook(@RequestBody Book book) {
		if (!bookService.checkCode(book.getBookCode())) {
			return bookService.addBook(book);
		}
		return "Enter a Unique Book Code";
	}

	@PostMapping("/checkcode")
	public boolean checkTheBookCode(@RequestBody String code) {
		return bookService.checkCode(code);
	}

}
