package com.SmartShop.SmartShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SmartShop.SmartShop.entities.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository <User, Long> {
    Optional<User> findByUsername(String username);
}
