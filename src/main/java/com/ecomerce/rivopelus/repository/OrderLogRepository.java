package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.OrdersLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository <OrdersLog, String> {
}
