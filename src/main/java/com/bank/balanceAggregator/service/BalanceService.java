package com.bank.balanceAggregator.service;

import com.bank.balanceAggregator.domain.Transaction;

import java.util.Date;
import java.util.List;

public interface BalanceService {

    Double calculateMonthlyBalance(List<Transaction> transactions, Date date);

    Double calculateCumulativeBalance(List<Transaction> transactions);

}
