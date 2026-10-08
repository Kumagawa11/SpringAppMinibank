package com.example.minibank.domain.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minibank.domain.model.TransactionModel;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>{

	List<TransactionModel> getTransactionByAccountId(Integer accountId);
	
}
