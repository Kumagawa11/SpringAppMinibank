package com.example.minibank.domain.repository;

import java.util.Optional;

import jakarta.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.example.minibank.domain.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Integer>{

	Optional<AccountModel> getAccountByUserId(Integer userId);
	Optional<AccountModel> getAccountByAccountNumber(Integer accountNumber);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT a FROM AccountModel a WHERE a.id = :id")
	Optional<AccountModel> getAccountByUserIdForUpdate(Integer userId);

}
