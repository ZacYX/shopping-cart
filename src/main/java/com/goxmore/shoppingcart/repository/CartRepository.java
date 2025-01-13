package com.goxmore.shoppingcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goxmore.shoppingcart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  public Optional<Cart> findByUserId(Long userId);
}