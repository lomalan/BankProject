package com.lomalan.bankproject.entities.dto;

import java.time.LocalDateTime;

public class BankTransactionDto {

    private Long id;
    private LocalDateTime transactionDate;
    private AccountDto accountSender;
    private AccountDto accountReceiver;
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public AccountDto getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(AccountDto accountSender) {
        this.accountSender = accountSender;
    }

    public AccountDto getAccountReceiver() {
        return accountReceiver;
    }

    public void setAccountReceiver(AccountDto accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
