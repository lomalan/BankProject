package com.lomalan.bankproject.services.interfaces;


import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.dto.BankTransactionDto;
import com.lomalan.bankproject.entities.dto.ClientDto;

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
    void saveTransaction(BankTransactionDto bankTransaction);
    List<BankTransaction> findTransactionByClient(ClientDto client);
    List<BankTransaction> findAllTransactionByPeriod(LocalDateTime from, LocalDateTime to);
    List<BankTransaction> findAllTransactions();
}
