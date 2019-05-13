package com.lomalan.bankproject.entities.converter;

import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.entities.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class AccountDtoToAccount implements Converter<AccountDto, Account> {

    private ClientDtoToClient clientDtoToClient;

    @Autowired
    public void setClientDtoToClient(ClientDtoToClient clientDtoToClient) {
        this.clientDtoToClient = clientDtoToClient;
    }

    @Override
    public Account convert(AccountDto accountDto) {

        if(accountDto == null){
            return null;
        }

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setAmount(accountDto.getAmount());
        account.setAccountNumber(accountDto.getAccountNumber());
        if(accountDto.getClient()!= null){
            account.setClient(clientDtoToClient.convert(accountDto.getClient()));
        }
        return account;
    }
}
