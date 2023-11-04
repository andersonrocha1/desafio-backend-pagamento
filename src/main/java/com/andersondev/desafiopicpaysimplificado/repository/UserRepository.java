package com.andersondev.desafiopicpaysimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.desafiopicpaysimplificado.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
