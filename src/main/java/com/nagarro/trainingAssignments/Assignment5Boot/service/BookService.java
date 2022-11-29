package com.nagarro.trainingAssignments.Assignment5Boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.Book;
import com.nagarro.trainingAssignments.Assignment5Boot.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public String addBook(Book book) {
		bookRepository.save(book);
		return "Successfully added Book " + book.toString();

	}

	public List<Book> listAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}

	public String deleteBook(int id) {
		bookRepository.deleteById(id);
		return "Book is removed !! id: " + id;
	}

	public boolean checkCode(String bkCode) {
		return bookRepository.existsByBookCode(bkCode);
	}

	public String updateBook(Book book) {
		Book existingBook = bookRepository.findById(book.getBookId()).orElse(null);
		existingBook.setName(book.getName());
		existingBook.setBookCode(book.getBookCode());
		existingBook.setAuthor(book.getAuthor());
		bookRepository.save(existingBook);
		return "Succesfully Updated Book: " + book.getBookCode();
	}

}
