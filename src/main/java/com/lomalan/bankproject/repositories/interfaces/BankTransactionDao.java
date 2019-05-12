package com.lomalan.bankproject.repositories.interfaces;

import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.Client;

import java.time.LocalDateTime;
import java.util.List;
/**
 * <p>
 *     This class represented interface for BankTransaction DAO.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

public interface BankTransactionDao extends GenericDao<BankTransaction, Long> {
    List<BankTransaction> findTransactionByClient(Client client);
    List<BankTransaction> findTransactionsByDate(LocalDateTime from, LocalDateTime to);
}
