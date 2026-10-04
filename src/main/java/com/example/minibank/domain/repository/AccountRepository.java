package com.example.minibank.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minibank.domain.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Integer>{

	Optional<AccountModel> getAccountByUserId(Integer userId);
	Optional<AccountModel> getAccountByAccountNumber(Integer accountNumber);

}
