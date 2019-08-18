package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.CategoryDao;
import io.khasang.gahelp.entity.Category;

import java.util.List;

public class CategoryDaoImpl extends BasicDaoImpl<Category> implements CategoryDao {

    public CategoryDaoImpl(Class<Category> entityClass) {
        super(entityClass);
    }
}
