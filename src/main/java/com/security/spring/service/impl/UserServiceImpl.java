package com.security.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.spring.entity.User;
import com.security.spring.repo.UserRepository;
import com.security.spring.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.security.spring.entity.User> userOptional = userRepo.findByUserName(username);
		if(userOptional.isPresent()) return new MyUserDetails(userOptional.get());
		return null;
	}

	@Override
	public void registerUser(User user) {
		System.out.print(user.isActive());
		userRepo.save(user);
	}

}
