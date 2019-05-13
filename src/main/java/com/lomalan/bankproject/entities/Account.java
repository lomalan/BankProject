package com.lomalan.bankproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * <p>
 *     This class is an entity of Account.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Entity
public class Account extends AbstractEntity{

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "account_client_FK"))
    private Client client;

    @Column(nullable = false, unique = true)
    private Long accountNumber;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) { this.client = client; }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof Account)) return false;
        Account account = (Account) o;
        return (getAmount() != null && getAmount().equals(account.getAmount())) &&
                (getName() != null && getName().equals(account.getName())) &&
                (getClient() != null && getClient().equals(account.getClient())) &&
                (getAccountNumber() != null && getAccountNumber().equals(account.getAccountNumber()));

    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getName(), getClient(), getAccountNumber());
    }
}
