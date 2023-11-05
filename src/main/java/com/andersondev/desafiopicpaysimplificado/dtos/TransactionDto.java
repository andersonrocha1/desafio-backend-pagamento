package com.andersondev.desafiopicpaysimplificado.dtos;

import java.math.BigDecimal;

public record TransactionDto(
		
		BigDecimal amount,
		Long payerid,
		Long payeeid
		
		) {
	
}
