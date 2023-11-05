package com.andersondev.desafiopicpaysimplificado.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andersondev.desafiopicpaysimplificado.dtos.TransactionDto;
import com.andersondev.desafiopicpaysimplificado.model.Transaction;
import com.andersondev.desafiopicpaysimplificado.repository.TransactionRepository;

@Service
public class TransactionService {

	private final UserService userService;
	
	
	private final RestTemplate restTemplate;
	
	private final TransactionRepository transactionRepository; 
	
	private final NotificationService notificationService;
	
	
	
	public TransactionService(UserService userService, 
			TransactionRepository transactionRepository, NotificationService notificationService, RestTemplate restTemplate ) {
		
		this.userService = userService;
		this.transactionRepository = transactionRepository;
		this.notificationService = notificationService;
		this.restTemplate = restTemplate;
	}



	public Transaction createTransaction(TransactionDto transactionDto) throws Exception {
		
		var payer = userService.findUserById(transactionDto.payerid());
		var payee = userService.findUserById(transactionDto.payeeid());
		
		
		userService.validaUser(payer, transactionDto.amount());
		
		boolean isAuthorize = authorizeTransaction();
		
		if(!isAuthorize) {
			
			throw new Exception("Transação não autorizada");
		}
		
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDto.amount());
		transaction.setPayer(payer);
		transaction.setPayee(payee);
		transaction.setTransactionDateTime(LocalDateTime.now());
		
		payer.setBalance(payer.getBalance().subtract(transactionDto.amount()));
		payee.setBalance(payee.getBalance().add(transactionDto.amount()));
		
		transactionRepository.save(transaction);
		userService.insertUser(payer);
		userService.insertUser(payee);
		
		
		notificationService.sendNotification(payer, "Transação realizada com sucesso!");
		notificationService.sendNotification(payee, "Transação recebida com sucesso!");
		
		return transaction;
	}

	
	public boolean authorizeTransaction() {
		
		var authorize = restTemplate.getForEntity("http://echo.jsontest.com/message/Autorizado", Map.class);
		
		if(authorize.getStatusCode() == HttpStatus.OK) {
			
			String message = (String) authorize.getBody().get("message");
			
			return "Autorizado".equalsIgnoreCase(message);
		}else {
			
			return false;
		}
		
	}
	
	

}
