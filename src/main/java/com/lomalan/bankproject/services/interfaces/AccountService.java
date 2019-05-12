package com.lomalan.bankproject.services.interfaces;

import com.lomalan.bankproject.entities.Account;

import java.util.List;

/**
 * <p>
 *     This interface is representation of Account Service
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */

public interface AccountService {

    List<Account> findAllAccountsByClient(Long id);
    void saveAccount(Account account, Long clientId);
    void updateAccount(Account account);
}
