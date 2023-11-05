package com.andersondev.desafiopicpaysimplificado.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersondev.desafiopicpaysimplificado.dtos.TransactionDto;
import com.andersondev.desafiopicpaysimplificado.model.Transaction;
import com.andersondev.desafiopicpaysimplificado.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	
	
	public TransactionController(TransactionService transactionService) {
		
		this.transactionService = transactionService;
	}


    @PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transactionDto) throws Exception{
		
		var transaction = transactionService.createTransaction(transactionDto);
		
		return new ResponseEntity<>(transaction, HttpStatus.CREATED);
		
	}

}
