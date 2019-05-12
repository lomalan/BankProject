package com.lomalan.bankproject.repositories.implementations;

import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.repositories.interfaces.AccountDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *     This class is implementation of {@link AccountDao}
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {
    public AccountDaoImpl() { super(Account.class); }

    @Override
    public List<Account> findAllAccountsByClient(Long id) {
        Assert.notNull(id, "Id cannot be null");

        return getEntityManager().createQuery("SELECT i from " + getClazz().getSimpleName() +
                " i where i.client.id = :clientId", getClazz()).setParameter("clientId", id).getResultList();
    }
}
