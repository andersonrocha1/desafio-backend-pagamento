package com.andersondev.desafiopicpaysimplificado.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersondev.desafiopicpaysimplificado.dtos.UserDto;
import com.andersondev.desafiopicpaysimplificado.model.User;
import com.andersondev.desafiopicpaysimplificado.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {

		User user = userService.createUser(userDto);

		return new ResponseEntity<>(user, HttpStatus.CREATED);

	}

}
