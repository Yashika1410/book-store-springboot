package com.nagarro.trainingAssignments.Assignment5Boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	boolean existsByBookCode(String bookCode);
	

}
