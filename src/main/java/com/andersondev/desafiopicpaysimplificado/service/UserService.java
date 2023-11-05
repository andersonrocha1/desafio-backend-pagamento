package com.andersondev.desafiopicpaysimplificado.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andersondev.desafiopicpaysimplificado.dtos.UserDto;
import com.andersondev.desafiopicpaysimplificado.enums.UserType;
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


	public List<User> listUsers() {
		
		return userRepository.findAll();
	}
	
	
	public User findUserById(Long id) throws Exception {
		
		return userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não existe!"));
		
	}


	public boolean validaUser(User payer, BigDecimal amount) throws Exception {
		
		if(payer.getUserType() == UserType.MERCHANT) {
			
			throw new Exception("Operação não permitida a Logistas!");
			
		} 
		
		else if(payer.getBalance().compareTo(amount) < 0) {
			
			throw new Exception("Saldo Insuficiente");
			
		}
		
		return true;
		
	}

}
