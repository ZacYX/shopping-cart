package com.goxmore.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goxmore.shoppingcart.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
