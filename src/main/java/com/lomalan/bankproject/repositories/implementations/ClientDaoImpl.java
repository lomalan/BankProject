package com.lomalan.bankproject.repositories.implementations;

import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.repositories.interfaces.ClientDao;
import org.springframework.stereotype.Repository;


/**
 * <p>
 *     This class is implementation of {@link ClientDao}
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {
    public ClientDaoImpl() { super(Client.class); }
}
