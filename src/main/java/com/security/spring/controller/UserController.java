package com.security.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring.entity.User;
import com.security.spring.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/messages")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getWelcomeNote(Principal principal) {
		return "Welcome to Server" + principal.getName();
	}
	
	@PostMapping("/users")
	public String registration(@RequestBody User user) {
		userService.registerUser(user);
		return "success";
	}
}
