package com.lomalan.bankproject.repositories.implementations;

import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.repositories.interfaces.ClientDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;


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

    @Override
    public Client findClientByEmail(String email) {
        Assert.notNull(email, "Email cannot be null");

        List<Client> result = getEntityManager()
                .createQuery("SELECT i FROM "+ getClazz().getSimpleName() + " i where i.email = :email",
                        getClazz())
                .setParameter("email", email)
                .getResultList();

        if(!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }
}
