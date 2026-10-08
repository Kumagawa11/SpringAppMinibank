package com.example.minibank.domain.service.history;

import java.util.List;

import com.example.minibank.domain.model.TransactionModel;

public interface HistoryService {

	public List<TransactionModel> getHistoryByAccountId(Integer accountId);
	
}
