package com.andersondev.desafiopicpaysimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.desafiopicpaysimplificado.model.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
