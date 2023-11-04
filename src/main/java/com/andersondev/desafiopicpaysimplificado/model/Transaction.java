package com.andersondev.desafiopicpaysimplificado.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "payer_id")
	private User payer;
	
	@ManyToOne
	@JoinColumn(name = "payee_id")
	private User payee;
	
	
    private LocalDateTime transactionDateTime;
    
    public Transaction() {
    	
    }

	public Transaction(Long id, BigDecimal amount, User payer, User payee, LocalDateTime transactionDateTime) {
		super();
		this.id = id;
		this.amount = amount;
		this.payer = payer;
		this.payee = payee;
		this.transactionDateTime = transactionDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getPayer() {
		return payer;
	}

	public void setPayer(User payer) {
		this.payer = payer;
	}

	public User getPayee() {
		return payee;
	}

	public void setPayee(User payee) {
		this.payee = payee;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", payer=" + payer + ", payee=" + payee
				+ ", transactionDateTime=" + transactionDateTime + "]";
	}
    
    
	
	
	
}
