package com.example.minibank.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.minibank.domain.model.AccountModel;

public interface AccountService {

	public List<AccountModel> getAll();
	
	public Optional<AccountModel> getAccountByUserId(int userId);
	
	public BigDecimal getBalanceByUserId(int userId);
	
	public Optional<AccountModel> getAccountByAccountNumber(Integer accountNumber);

	
}
