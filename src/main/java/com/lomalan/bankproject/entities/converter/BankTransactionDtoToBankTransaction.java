package com.lomalan.bankproject.entities.converter;


import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.dto.BankTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BankTransactionDtoToBankTransaction implements Converter<BankTransactionDto, BankTransaction> {

    private AccountDtoToAccount accountDtoToAccount;

    @Autowired
    public void setAccountDtoToAccount(AccountDtoToAccount accountDtoToAccount) {
        this.accountDtoToAccount = accountDtoToAccount;
    }

    @Override
    public BankTransaction convert(BankTransactionDto bankTransactionDto) {

        if(bankTransactionDto == null){
            return null;
        }

        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setId(bankTransactionDto.getId());
        bankTransaction.setTransactionDate(bankTransactionDto.getTransactionDate());
        if(bankTransactionDto.getAccountSender() != null){
            bankTransaction.setAccountSender(accountDtoToAccount.convert(bankTransactionDto.getAccountSender()));
        }
        if(bankTransactionDto.getAccountReceiver()!= null){
            bankTransaction.setAccountReceiver(accountDtoToAccount.convert(bankTransactionDto.getAccountReceiver()));
        }
        bankTransaction.setAmount(bankTransactionDto.getAmount());

        return bankTransaction;
    }
}
