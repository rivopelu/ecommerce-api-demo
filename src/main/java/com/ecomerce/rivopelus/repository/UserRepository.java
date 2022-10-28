package com.ecomerce.rivopelus.repository;

import com.ecomerce.rivopelus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
