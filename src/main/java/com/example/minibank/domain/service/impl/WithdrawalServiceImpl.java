package com.example.minibank.domain.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.minibank.domain.model.AccountModel;
import com.example.minibank.domain.model.TransactionModel;
import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.domain.repository.TransactionRepository;
import com.example.minibank.domain.service.AccountService;
import com.example.minibank.domain.service.WithdrawalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WithdrawalServiceImpl implements WithdrawalService {

	private final TransactionRepository txRepository;
	private final AccountService accountService;

	@Transactional
	@Override
	public void withdrawal(int userId, BigDecimal amount, TransactionType type, String description) {

		AccountModel targetAccount = accountService.getAccountByUserId(userId).get();

		TransactionModel tx = new TransactionModel(
				targetAccount.getAccountNumber(),
				type,
				amount,
				description,
				LocalDateTime.now());

		targetAccount.withdrawal(amount);
		txRepository.save(tx);

	}

}
