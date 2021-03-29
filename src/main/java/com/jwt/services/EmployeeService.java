package com.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.model.ResponseMsg;
import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@Service
public class EmployeeService {

	@Autowired
	private UserRepository userRepository;
	
	private ResponseMsg responceMsg;
	
	
	public User addNew(User user) {
		return userRepository.save(user);
	}
}
