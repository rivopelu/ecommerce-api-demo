package com.ecomerce.rivopelus.controllers;

import com.ecomerce.rivopelus.entities.Category;
import com.ecomerce.rivopelus.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> findAllCategory() {
        return categoryService.finAll();
    }

    @GetMapping("/find/{id}")
    public Category findById(@PathVariable("id") String id) {
        return categoryService.FindById(id);
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.edit(category);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        categoryService.deleteById(id);
        return "Success";
    }

}
