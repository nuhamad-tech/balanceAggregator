package com.bank.balanceAggregator.controller;

import com.bank.balanceAggregator.domain.Transaction;
import com.bank.balanceAggregator.service.BalanceService;
import com.bank.balanceAggregator.service.TransactionClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    BalanceService balanceService;

    @Autowired
    TransactionClientService transactionClientService;

    @GetMapping(value = "/customer/{customerId}/monthlyBalance")
    public Double getMonthlyBalance(@PathVariable String customerId) {
         List<Transaction> transactions = transactionClientService.getTransactions(customerId).orElseThrow(()->
                 new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
         return balanceService.calculateMonthlyBalance(transactions, new Date());
    }

    @GetMapping(value = "/customer/{customerId}/cumulativeBalance")
    public Double getCumulativeBalance(@PathVariable String customerId) {
        List<Transaction> transactions = transactionClientService.getTransactions(customerId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
        return balanceService.calculateCumulativeBalance(transactions);
    }
}
