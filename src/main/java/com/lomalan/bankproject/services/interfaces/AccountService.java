package com.lomalan.bankproject.services.interfaces;

import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.entities.dto.AccountDto;

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
    void saveAccount(AccountDto account, Long clientId);
    void updateAccount(AccountDto accountDto);
}
