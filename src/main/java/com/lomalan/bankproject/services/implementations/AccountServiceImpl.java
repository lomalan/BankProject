package com.lomalan.bankproject.services.implementations;


import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.repositories.interfaces.AccountDao;
import com.lomalan.bankproject.repositories.interfaces.ClientDao;
import com.lomalan.bankproject.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 * This class is implementation of {@link AccountService}
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private ClientDao clientDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) { this.accountDao = accountDao; }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Account> findAllAccountsByClient(Long id) {
        return accountDao.findAllAccountsByClient(id);
    }

    @Override
    public void saveAccount(Account account, Long clientId) {
        Client client = clientDao.findById(clientId);
        Assert.notNull(client, "Client not found");
        account.setClient(client);
        accountDao.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }
}
