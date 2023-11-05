package com.andersondev.desafiopicpaysimplificado.dtos;

import java.math.BigDecimal;

public record TransactionDto(
		
		BigDecimal amount,
		Long payer_id,
		Long payee_id
		
		) {
	
}
