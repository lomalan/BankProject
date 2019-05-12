package com.lomalan.bankproject.services.interfaces;


import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.Client;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *     This interface is representation of Bank Transaction Service
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */

public interface BankTransactionService {
    void saveTransaction(BankTransaction bankTransaction);
    List<BankTransaction> findTransactionByClient(Client client);
    List<BankTransaction> findAllTransactionByPeriod(LocalDateTime from, LocalDateTime to);
    List<BankTransaction> findAllTransactions();
}
