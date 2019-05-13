package com.lomalan.bankproject.repositories.interfaces;

import com.lomalan.bankproject.entities.Client;
/**
 * <p>
 *     This class represented interface for Client DAO.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

public interface ClientDao extends GenericDao<Client, Long> {

    Client findClientByEmail(String email);
}
