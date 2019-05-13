package com.lomalan.bankproject.services.implementations;

import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.entities.converter.ClientDtoToClient;
import com.lomalan.bankproject.entities.dto.ClientDto;
import com.lomalan.bankproject.repositories.interfaces.ClientDao;
import com.lomalan.bankproject.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
/**
 * <p>
 * This class is implementation of {@link ClientService}
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ClientDtoToClient clientDtoToClient;

    @Autowired
    public void setClientDtoToClient(ClientDtoToClient clientDtoToClient) {
        this.clientDtoToClient = clientDtoToClient;
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public List<Client> findAll() {

        return clientDao.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientDao.findById(id);
    }

    @Override
    @Transactional
    public void saveClient(ClientDto clientDto) {
        Assert.notNull(clientDto, "Client cannot be null");
        Assert.notNull(clientDto.getAddress(), "Address cannot be null");
        Assert.notNull(clientDto.getAge(), "Age cannot be null");
        Assert.notNull(clientDto.getEmail(), "Email cannot be null");
        Assert.notNull(clientDto.getFirstName(), "First name cannot be null");
        Assert.notNull(clientDto.getLastName(), "Last name cannot be null");
        Client client = clientDtoToClient.convert(clientDto);
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void updateClient(Client client) {
        clientDao.update(client);
    }
}
