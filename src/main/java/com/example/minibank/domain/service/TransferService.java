package com.example.minibank.domain.service;

import java.math.BigDecimal;

import com.example.minibank.domain.model.TransactionType;

public interface TransferService {

	public void transfer(int userId, int toAccount, BigDecimal amount, TransactionType type, String description);
	
	
}
