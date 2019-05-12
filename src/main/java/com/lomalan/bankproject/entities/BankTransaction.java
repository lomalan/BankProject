package com.lomalan.bankproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * <p>
 *     This class is an entity of BankTransaction.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Entity
@Table(name = "bank_transaction")
public class BankTransaction extends AbstractEntity{

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_sender_id", foreignKey = @ForeignKey(name = "sender_transaction_FK"))
    private Account accountSender;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_receiver_id", foreignKey = @ForeignKey(name = "receiver_transaction_FK"))
    private Account accountReceiver;

    @Column(nullable = false)
    private Double amount;

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Account getAccountReceiver() {
        return accountReceiver;
    }

    public void setAccountReceiver(Account accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
