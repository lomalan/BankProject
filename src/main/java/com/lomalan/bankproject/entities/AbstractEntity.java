package com.lomalan.bankproject.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>
 *     This class represented abstract Entity with one column <b>id</b> with is mandatory for all entities in the system
 *     and this column is a Primary key.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
