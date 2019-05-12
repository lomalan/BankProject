package com.lomalan.bankproject.repositories.implementations;

import com.lomalan.bankproject.repositories.interfaces.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * <p>
 *     This class is abstract and generic implementation of {@link GenericDao}
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */
public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {

    private final Class<T> clazz;
    private EntityManager entityManager;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected Class<T> getClazz() {
        return clazz;
    }

    @Override
    public T findById(ID id) {
        return getEntityManager().find(getClazz(), id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + getClazz().getSimpleName(), getClazz()).getResultList();
    }

    @Override
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public T update(T entity) {
        return getEntityManager().merge(entity);
    }
}
