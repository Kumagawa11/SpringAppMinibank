package com.example.minibank.domain.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.minibank.domain.model.AccountModel;
import com.example.minibank.domain.repository.AccountRepository;
import com.example.minibank.domain.service.AccountService;
import com.example.minibank.exception.AccountNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	private final AccountRepository accountRepository;

	@Override
	public List<AccountModel> getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Optional<AccountModel> getAccountByUserId(int userId) throws AccountNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		Optional<AccountModel> account = Optional.ofNullable(accountRepository.getAccountByUserId(userId).orElseThrow(() -> new AccountNotFoundException("対象ユーザーの口座が存在しません")));
		return account;
	}

	@Override
	public BigDecimal getBalanceByUserId(int userId) {
		// TODO 自動生成されたメソッド・スタブ
		AccountModel account = this.getAccountByUserId(userId).get();
		
		return account.getBalance();
		
	}

	@Override
	public Optional<AccountModel> getAccountByAccountNumber(Integer accountNumber) {
		Optional<AccountModel> account = 
				accountRepository.getAccountByAccountNumber(accountNumber);
		
		return account;
		
	}

	


	
}
