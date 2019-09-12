package io.khasang.gahelp.dao;

import java.util.List;

public interface BasicDao<T> {
    /**
     * service for adding entity
     *
     * @param entity for adding
     * @return added entity
     */
    T add(T entity);

    /**
     * service for adding entity
     *
     * @param entity for adding
     * @return added entity
     */
    T update(T entity);

    /**
     * service for getting entity by id
     *
     * @param id - entity's id
     * @return specific entity by id
     */
    T getById(long id);

    /**
     * service for getting all entity
     *
     * @return all entities
     */
    List<T> getAll();

    /**
     * service for deletion entity
     *
     * @param entity - entity for delete
     * @return deleted entity
     */
    T delete(T entity);

}
