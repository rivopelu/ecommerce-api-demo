package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <Orders, String> {
}
