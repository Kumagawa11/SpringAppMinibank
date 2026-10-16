package com.example.minibank.domain.service.withdrawal;

import java.math.BigDecimal;

import com.example.minibank.domain.model.TransactionType;

public interface WithdrawalService {

	public void withdrawal(int userId, BigDecimal amount, TransactionType type, String description);

}
