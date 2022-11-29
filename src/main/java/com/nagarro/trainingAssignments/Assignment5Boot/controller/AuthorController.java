package com.nagarro.trainingAssignments.Assignment5Boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.Author;
import com.nagarro.trainingAssignments.Assignment5Boot.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping("/allauthor")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}

	@GetMapping("/getauthor/{id}")
	public Author getAuthor(@PathVariable int id) {
		return authorService.getAuthorByid(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAuthor(@PathVariable int id) {
		return authorService.deleteAuthor(id);
	}

	@PutMapping("/update")
	public String updateAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}

	@PostMapping("/addauthor")
	public String addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);

	}

}
