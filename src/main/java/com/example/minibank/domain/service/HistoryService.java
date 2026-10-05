package com.example.minibank.domain.service;

import java.util.List;

import com.example.minibank.domain.model.TransactionModel;

public interface HistoryService {

	public List<TransactionModel> getHistoryByAccountId(Integer accountId);
	
}
