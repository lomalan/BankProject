package com.lomalan.bankproject.repositories.implementations;

import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.repositories.interfaces.BankTransactionDao;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *     This class is implementation of {@link BankTransactionDao}
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */
@Repository
public class BankTransactionDaoImpl extends GenericDaoImpl<BankTransaction, Long> implements BankTransactionDao {
    public BankTransactionDaoImpl() {
        super(BankTransaction.class);
    }

    @Override
    public List<BankTransaction> findTransactionByClient(Client client) {
        String sqlQuery = " select i from " + getClazz().getSimpleName() + " i " +
                " where i.accountSender in (:idList) OR i.accountReceiver in (:idList)";

        return getEntityManager()
                .createQuery(sqlQuery, getClazz())
                .setParameter("idList", client.getAccounts())
                .getResultList();
    }

    @Override
    public List<BankTransaction> findTransactionsByDate(LocalDateTime from, LocalDateTime to) {
        return getEntityManager()
                .createQuery("select i from " + getClazz().getSimpleName() + " i " +
                "where i.transactionDate between :fromDate and :toDate", getClazz())
                .setParameter("fromDate", from)
                .setParameter("toDate", to)
                .getResultList();
    }
}
