package com.ecomerce.rivopelus.controllers;

import com.ecomerce.rivopelus.entities.Product;
import com.ecomerce.rivopelus.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/")
    public List<Product> findAll() {
        return productsService.findAllProducts();
    }

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable("id") String id) {
        return productsService.findById(id);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productsService.createProduct(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productsService.editProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productsService.deleteProduct(id);
        return "Success";
    }
}
