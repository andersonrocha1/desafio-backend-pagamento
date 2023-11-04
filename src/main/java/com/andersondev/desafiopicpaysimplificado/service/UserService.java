package com.andersondev.desafiopicpaysimplificado.service;

import org.springframework.stereotype.Service;

import com.andersondev.desafiopicpaysimplificado.dtos.UserDto;
import com.andersondev.desafiopicpaysimplificado.model.User;
import com.andersondev.desafiopicpaysimplificado.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	

	public UserService(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	}


	public void insertUser(User user ) {
		
		userRepository.save(user);
		
	}

	public User createUser(UserDto userDto) {
		
		User newuser = new User(userDto);
		this.insertUser(newuser);
		
		return newuser;
		
	}

}
