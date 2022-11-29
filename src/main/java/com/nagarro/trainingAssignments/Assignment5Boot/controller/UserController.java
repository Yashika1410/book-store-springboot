package com.nagarro.trainingAssignments.Assignment5Boot.controller;

import com.nagarro.trainingAssignments.Assignment5Boot.entity.User;
import com.nagarro.trainingAssignments.Assignment5Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		System.out.println(user.getEmail());
		return userService.login(user.getEmail(), user.getPassword());
	}

	@PostMapping("/adduser")
	public String createUser(@RequestBody User user) {
		if (!userService.checkEmail(user.getEmail())) {
			return userService.addUser(user);
		}
		return "Email already Exists";
	}

}
