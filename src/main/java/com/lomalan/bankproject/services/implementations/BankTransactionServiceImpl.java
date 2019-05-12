package com.lomalan.bankproject.services.implementations;

import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.repositories.implementations.AccountDaoImpl;
import com.lomalan.bankproject.repositories.interfaces.BankTransactionDao;
import com.lomalan.bankproject.repositories.interfaces.ClientDao;
import com.lomalan.bankproject.services.interfaces.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
/**
 * <p>
 * This class is implementation of {@link BankTransactionService}
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */

@Transactional
@Service
public class BankTransactionServiceImpl implements BankTransactionService {
    
    private BankTransactionDao bankTransactionDao;
    private AccountDaoImpl accountDao;
    private ClientDao clientDao;

    @Autowired
    public void setBankTransactionDao(BankTransactionDao bankTransactionDao) {
        this.bankTransactionDao = bankTransactionDao;
    }

    @Autowired
    public void setAccountDao(AccountDaoImpl accountDao) {

        this.accountDao = accountDao;
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void saveTransaction(BankTransaction bankTransaction) {
        Assert.notNull(bankTransaction, "BankTransaction cannot be null");
        bankTransaction.setTransactionDate(LocalDateTime.now());
        if(Objects.nonNull(bankTransaction.getAccountSender()) && Objects.nonNull(bankTransaction.getAccountReceiver())){
            transferBetweenTwoAccounts(bankTransaction);
        }
        if(Objects.isNull(bankTransaction.getAccountSender()) && Objects.nonNull(bankTransaction.getAccountReceiver())){
            replenishToAccount(bankTransaction);
        }
        if(Objects.isNull(bankTransaction.getAccountReceiver()) && Objects.nonNull(bankTransaction.getAccountSender())){
            withdrawFromAccount(bankTransaction);
        }
    }

    @Override
    public List<BankTransaction> findTransactionByClient(Client client) {
        Assert.notNull(client, "Client cannot be null");
        Client saved = clientDao.findById(client.getId());
        Assert.notNull(saved, "Client not found");
        if(saved.getAccounts().isEmpty()) {
            throw new IllegalArgumentException("Client doesn't have any accounts!");
        }
        return bankTransactionDao.findTransactionByClient(saved);
    }

    @Override
    public List<BankTransaction> findAllTransactionByPeriod(LocalDateTime from, LocalDateTime to) {

        return bankTransactionDao.findTransactionsByDate(from, to);
    }

    @Override
    public List<BankTransaction> findAllTransactions() {

        return bankTransactionDao.findAll();
    }

    private void withdrawFromAccount(BankTransaction bankTransaction){
        Account sender = accountDao.findById(bankTransaction.getAccountSender().getId());
        Assert.notNull(sender, "Account not found");
        sender.setAmount(sender.getAmount() - bankTransaction.getAmount());

        checkAvailableFunds(sender);
        bankTransaction.setAccountSender(sender);
        accountDao.update(sender);
        bankTransactionDao.save(bankTransaction);
    }
    private void transferBetweenTwoAccounts(BankTransaction bankTransaction){
        Account sender = accountDao.findById(bankTransaction.getAccountSender().getId());
        Account receiver = accountDao.findById(bankTransaction.getAccountReceiver().getId());

        checkAccount(sender);
        checkAccount(receiver);

        sender.setAmount(sender.getAmount() - bankTransaction.getAmount());
        checkAvailableFunds(sender);
        receiver.setAmount(receiver.getAmount() + bankTransaction.getAmount());

        bankTransaction.setAccountSender(sender);
        bankTransaction.setAccountReceiver(receiver);
        accountDao.update(sender);
        accountDao.update(receiver);
        bankTransactionDao.save(bankTransaction);
    }

    private void replenishToAccount(BankTransaction bankTransaction){
        Account receiver = accountDao.findById(bankTransaction.getAccountReceiver().getId());
        checkAccount(receiver);

        receiver.setAmount(receiver.getAmount() + bankTransaction.getAmount());

        bankTransaction.setAccountReceiver(receiver);
        accountDao.update(receiver);
        bankTransactionDao.save(bankTransaction);
    }

    private void checkAccount(Account account){
        Assert.notNull(account, "Account not found");
    }

    private void checkAvailableFunds(Account account){
        if(account.getAmount() < 0){ throw new IllegalArgumentException("Insufficient funds!");}
    }

}