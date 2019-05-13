package com.lomalan.bankproject.services.interfaces;

import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.entities.dto.ClientDto;

import java.util.List;

/**
 * <p>
 *     This interface is representation of Client Service
 * </p>
 *
 * @author Anton Lomakin
 * @since 1.0
 */

public interface ClientService {
    List<Client> findAll();
    Client findById(Long id);
    void saveClient(ClientDto clientDto);
    void updateClient(Client client);

}
