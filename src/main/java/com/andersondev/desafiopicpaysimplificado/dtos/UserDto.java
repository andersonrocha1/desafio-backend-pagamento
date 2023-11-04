package com.andersondev.desafiopicpaysimplificado.dtos;

import java.math.BigDecimal;

import com.andersondev.desafiopicpaysimplificado.enums.UserType;

import jakarta.persistence.Column;

public record UserDto(
		
		Long id,
		
	    String nome,
		
		@Column(unique = true)
		 String document,
		
		@Column(unique = true)
		 String email,
		
		 String password,
		
		 UserType userType,
		
		 BigDecimal balance

		
		) {

}
