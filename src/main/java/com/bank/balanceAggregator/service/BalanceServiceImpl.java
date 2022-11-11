package com.bank.balanceAggregator.service;

import com.bank.balanceAggregator.domain.Transaction;
import com.bank.balanceAggregator.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Date;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public Double calculateMonthlyBalance(List<Transaction> transactions, Date date) {
        return transactions.stream()
                .filter(transaction -> isTransactionOnSameMonth(transaction, date))
                .map(Transaction::getAmount)
                .reduce(0d, Double::sum);
    }

    @Override
    public Double calculateCumulativeBalance(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(0d, Double::sum);
    }

    private boolean isTransactionOnSameMonth(Transaction transaction, Date date){
        Month currentMonth = DateUtil.dateToMonth(date);
        int currentYear = DateUtil.dateToYear(date);
        Month transactionMonth = DateUtil.dateToMonth(transaction.getDate());
        int transactionYear = DateUtil.dateToYear(transaction.getDate());
        return currentMonth.equals(transactionMonth) && (currentYear == transactionYear);
    }
}
