package com.SmartShop.SmartShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SmartShop.SmartShop.entities.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem , Long> {
}
