package com.bank.balanceAggregator.service;

import com.bank.balanceAggregator.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionClientService {
    Optional<List<Transaction>> getTransactions(String customerId);
}
