package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, String> {
}
