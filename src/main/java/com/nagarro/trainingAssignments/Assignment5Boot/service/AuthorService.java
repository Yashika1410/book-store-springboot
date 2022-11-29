package com.nagarro.trainingAssignments.Assignment5Boot.service;

import java.util.List;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.Author;
import com.nagarro.trainingAssignments.Assignment5Boot.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public String addAuthor(Author author) {
		authorRepository.save(author);
		return "Successfully added author " + author.toString();
	}

	public List<Author> getAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	public Author getAuthorByid(int id) {
		return authorRepository.findById(id).orElse(null);
	}

	public String deleteAuthor(int id) {
		authorRepository.deleteById(id);
		return "Author removed !! " + id;
	}

	public String updateAuthor(Author author) {
		Author existingAuthor = authorRepository.findById(author.getId()).orElse(null);
		existingAuthor.setName(author.getName());
		authorRepository.save(existingAuthor);
		return "Succesfully Updated Author: " + existingAuthor.toString();
	}

}
