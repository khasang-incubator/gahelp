package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Category;

import java.util.List;

public interface CategoryService {

    /**
     * service for adding category
     *
     * @param category for adding
     * @return added category
     */
    Category add(Category category);

    /**
     * service for getting category by id
     *
     * @param id - horse's id
     * @return specific horse by id
     */
    Category getById(long id);

    /**
     * service for getting all category
     *
     * @return all categories
     */
    List<Category> getAll();

    /**
     * service for deletion category
     *
     * @param id - category's id for delete
     * @return deleted category
     */
    Category delete(long id);

    /**
     * service for updating category
     * @param category - new category for updating in database
     * @return - updating category
     */
    Category update(Category category);
}
