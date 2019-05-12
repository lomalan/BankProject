package com.lomalan.bankproject.repositories.interfaces;

import java.util.List;

/**
 * <p>
 *     This class represented generic interface for all DAO.
 * </p>
 *
 * @param <T> an Entity for which DAO implementation is created.
 * @param <ID> an Unique Identifier of the Entity
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

public interface GenericDao<T, ID> {

    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    T update(T entity);

}
