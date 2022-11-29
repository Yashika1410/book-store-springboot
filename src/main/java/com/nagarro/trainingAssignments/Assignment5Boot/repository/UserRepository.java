package com.nagarro.trainingAssignments.Assignment5Boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
	boolean existsByEmail(String email);

}
