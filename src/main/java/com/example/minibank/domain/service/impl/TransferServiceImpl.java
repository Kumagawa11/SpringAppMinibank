package com.example.minibank.domain.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.minibank.domain.model.AccountModel;
import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.domain.service.AccountService;
import com.example.minibank.domain.service.TransferService;
import com.example.minibank.exception.AccountNotFoundException;
import com.example.minibank.exception.SameAccountTransferException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService{
	
	private final AccountService accountService; 

	@Override
	@Transactional
	public void transfer(int userId, int toAccount, BigDecimal amount, TransactionType type, String description) {
	
		
		AccountModel to = 
				accountService
				.getAccountByAccountNumber(toAccount)
				.orElseThrow(() -> new AccountNotFoundException(TransactionType.transfer + "口座"
						+ "が存在しません"));
		
		AccountModel from = 
				accountService.getAccountByUserId(userId).get();
		
		if(to.getAccountNumber() == from.getAccountNumber()) {
			
			throw new SameAccountTransferException("送金先と送金元が同一です");
			
		}
		
		
		
		to.deposit(amount);
		from.withdrawal(amount);

		
	}

	
}
