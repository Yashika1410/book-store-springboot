package com.nagarro.trainingAssignments.Assignment5Boot.service;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.User;
import com.nagarro.trainingAssignments.Assignment5Boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public String addUser(User user) {
		userRepository.save(user);
		return "Successfully added User " + user.toString();

	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "Book is removed !! id: " + id;
	}

	public boolean checkEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public String login(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			if (password.equals(user.getPassword()))
				return user.getUsername();
			else
				return null;

		} else
			return null;

	}

}
