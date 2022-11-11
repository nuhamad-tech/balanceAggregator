package com.bank.balanceAggregator.domain;

import java.util.Date;

public class Transaction {
    private Date date;
    private Double amount;

    public Transaction(Date date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
