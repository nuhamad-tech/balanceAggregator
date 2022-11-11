package com.bank.balanceAggregator.service;

import com.bank.balanceAggregator.domain.Transaction;
import com.bank.balanceAggregator.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BalanceServiceImplTest {
    private final BalanceService service = new BalanceServiceImpl();
    private final List<Transaction> transactions = Arrays.asList(
            new Transaction(DateUtil.generateDate(1998, Month.AUGUST, 1), 4.5d),
            new Transaction(DateUtil.generateDate(2015, Month.SEPTEMBER, 5), 5.5d),
            new Transaction(DateUtil.generateDate(2022, Month.OCTOBER, 10), 22.5d),
            new Transaction(DateUtil.generateDate(2022, Month.OCTOBER, 20), -12.5d),
            new Transaction(DateUtil.generateDate(2007, Month.OCTOBER, 20), 10d),
            new Transaction(DateUtil.generateDate(2015, Month.NOVEMBER, 25), 20d),
            new Transaction(DateUtil.generateDate(2022, Month.DECEMBER, 30), 0d)
    );

    @Test
    void calculateMonthlyBalance() {
        Double balance = service.calculateMonthlyBalance(transactions, DateUtil.generateDate(2022, Month.OCTOBER, 10));
        assertEquals(10, balance);
    }

    @Test
    void calculateCumulativeBalance() {
        Double balance = service.calculateCumulativeBalance(transactions);
        assertEquals(50, balance);
    }
}