package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Category;
import io.khasang.gahelp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Category addCategory(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategory(@PathVariable("id") long id) {
        return categoryService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Category deleteCategory(@PathVariable("id") long id) {
        return categoryService.delete(id);
    }

    @RequestMapping(value = "/update/{id}")
    @ResponseBody
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") long id){
        category.setId(id);
        return categoryService.update(category);
    }
}
