package com.andersondev.desafiopicpaysimplificado.service;

import org.springframework.stereotype.Service;

import com.andersondev.desafiopicpaysimplificado.model.User;

@Service
public class NotificationService {
	
	public void sendNotification(User user, String message) {
		
		String email = user.getEmail();
		
		System.out.println(email+message);
		
	}

}
