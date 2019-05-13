package com.lomalan.bankproject.repositories.interfaces;

import com.lomalan.bankproject.entities.Account;

import java.util.List;

/**
 * <p>
 *     This class represented interface for Account DAO.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

public interface AccountDao extends GenericDao<Account, Long> {

    List<Account> findAllAccountsByClient(Long id);
    Account findByAccountNumber(Long accountNumber);

}
