package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart, String> {
}
