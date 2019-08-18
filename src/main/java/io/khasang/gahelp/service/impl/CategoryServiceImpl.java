package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.CategoryDao;
import io.khasang.gahelp.entity.Category;
import io.khasang.gahelp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public Category getById(long id) {
        return categoryDao.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category delete(long id) {
        return categoryDao.delete(getById(id));
    }

    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }
}
