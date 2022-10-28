package com.ecomerce.rivopelus.services;

import com.ecomerce.rivopelus.entities.Product;
import com.ecomerce.rivopelus.exception.BadRequestException;
import com.ecomerce.rivopelus.exception.ResourceNotFoundException;
import com.ecomerce.rivopelus.repository.CategoryRepository;
import com.ecomerce.rivopelus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found ID : " + id));
    }

    public Product createProduct(Product product) {
        if (StringUtils.hasText(product.getName())) {
            throw new BadRequestException("Nama Product Tidak Bisa Kosong");
        } else if (product.getCategory() == null) {
            throw new BadRequestException("Kategory Tidak Bisa Kosong");
        } else if (StringUtils.hasText((product.getCategory().getId()))) {
            throw new BadRequestException("Kategory Id Tidak Bisa Kosong");
        } else {
            categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new BadRequestException("Category tidak terdaftar"));
            return productRepository.save(product); // TODO part 4 12:17
        }
    }

    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    public Product changeImageProduct(String id, String image) {
        Product product = findById(id);
        product.setImage(image);
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
