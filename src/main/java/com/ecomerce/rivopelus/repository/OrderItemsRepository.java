package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository <OrderItem, String> {
}
