package com.ecomerce.rivopelus.services;

import com.ecomerce.rivopelus.entities.Category;
import com.ecomerce.rivopelus.exception.ResourceNotFoundException;
import com.ecomerce.rivopelus.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category FindById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find category " + id));
    }

    public List<Category> finAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category edit(Category category) {
        return categoryRepository.save(category);
    }

    public String deleteById(String id) {
        categoryRepository.deleteById(id);
        return "Successfully deleted category ";
    }
}
