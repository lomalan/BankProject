package com.lomalan.bankproject.entities.converter;

import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.entities.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToClient implements Converter<ClientDto, Client> {

    private AccountDtoToAccount accountDtoToAccount;

    @Autowired
    public void setAccountDtoToAccount(AccountDtoToAccount accountDtoToAccount) {
        this.accountDtoToAccount = accountDtoToAccount;
    }

    @Override
    public Client convert(ClientDto clientDto) {
        if(clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setAddress(clientDto.getAddress());
        client.setEmail(clientDto.getEmail());
        client.setAge(clientDto.getAge());
        if(clientDto.getAccounts() != null && !(clientDto.getAccounts().isEmpty())){
            clientDto.getAccounts().forEach(accDto -> client.getAccounts().add(accountDtoToAccount.convert(accDto)));
        }

        return client;
    }
}
