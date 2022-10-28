package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
