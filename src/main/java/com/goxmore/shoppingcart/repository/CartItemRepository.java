package com.goxmore.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goxmore.shoppingcart.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
