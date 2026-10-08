package com.example.minibank.domain.service.deposit;

import java.math.BigDecimal;

import com.example.minibank.domain.model.TransactionType;

public interface DepositService{

	
	public void deposit(int userId, BigDecimal amount, TransactionType type, String description);
	
}
