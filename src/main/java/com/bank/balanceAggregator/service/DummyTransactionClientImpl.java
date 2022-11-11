package com.bank.balanceAggregator.service;

import com.bank.balanceAggregator.domain.Transaction;
import com.bank.balanceAggregator.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

@Service
public class DummyTransactionClientImpl implements TransactionClientService {

    private final static Map<String, List<Transaction>> dummyReadOnlyDB = new HashMap<>();
    static {
        List<Transaction> customer1Transactions = Arrays.asList(
                new Transaction(DateUtil.generateDate(1999, Month.FEBRUARY, 12), 3.14d),
                new Transaction(DateUtil.generateDate(2010, Month.NOVEMBER, 9), 700d),
                new Transaction(DateUtil.generateDate(2022, Month.NOVEMBER, 3), 63d)
        );
        List<Transaction> customer2Transactions = Arrays.asList(
                new Transaction(DateUtil.generateDate(1998, Month.MAY, 4), 198236.123d),
                new Transaction(DateUtil.generateDate(2015, Month.JUNE, 2), 0d),
                new Transaction(DateUtil.generateDate(2022, Month.DECEMBER, 12), 128d),
                new Transaction(DateUtil.generateDate(2007, Month.JANUARY, 9), -1000d),
                new Transaction(DateUtil.generateDate(2015, Month.JUNE, 2), 236.1235d),
                new Transaction(DateUtil.generateDate(2022, Month.DECEMBER, 12), 75623.2346d)
        );
        List<Transaction> customer3Transactions = Arrays.asList(
                new Transaction(DateUtil.generateDate(1999, Month.APRIL, 12), 3.14d),
                new Transaction(DateUtil.generateDate(2010, Month.DECEMBER, 1), 700d),
                new Transaction(DateUtil.generateDate(2022, Month.NOVEMBER, 9), 22d),
                new Transaction(DateUtil.generateDate(2022, Month.NOVEMBER, 30), 1d),
                new Transaction(DateUtil.generateDate(2022, Month.NOVEMBER, 25), -13d)
        );
        dummyReadOnlyDB.put("customer1", customer1Transactions);
        dummyReadOnlyDB.put("customer2", customer2Transactions);
        dummyReadOnlyDB.put("customer3", customer3Transactions);
        dummyReadOnlyDB.put("customer4", new ArrayList<>());
    }

    @Override
    public Optional<List<Transaction>> getTransactions(String customerId) {
        return Optional.ofNullable(dummyReadOnlyDB.get(customerId));
    }
}
