package com.example.minibank.domain.service.history;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.minibank.domain.infrastructure.TransactionRepository;
import com.example.minibank.domain.model.TransactionModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService{

	private final TransactionRepository txRepository;
	
	@Override
	public List<TransactionModel> getHistoryByAccountId(Integer accountId) {
		
		return txRepository.getTransactionByAccountId(accountId);
		
	}

	
	
}
