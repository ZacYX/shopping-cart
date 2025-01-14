package com.goxmore.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goxmore.shoppingcart.model.Cart;
import com.goxmore.shoppingcart.model.CartItem;
import com.goxmore.shoppingcart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;

  public CartServiceImpl(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  @Override
  public Cart createCart(String userId) {
    Cart cart = new Cart();
    cart.setUserId(userId);
    return cartRepository.save(cart);
  }

  @Override
  public Cart getCartByUserId(String userId) {
    Optional<Cart> optCart = cartRepository.findByUserId(userId);
    if (!optCart.isPresent()) {
      return createCart(userId);
    }
    return optCart.get();
  }

  @Override
  public Cart getCartById(Long cartId) {
    return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
  }

  @Override
  public Cart addItemToCart(Long cartId, CartItem cartItem) {
    Optional<Cart> optCart = cartRepository.findById(cartId);
    if (optCart.isEmpty()) {
      System.out.println("cart not found");
      return null;
    }
    Cart cart = optCart.get();
    cartItem.setCart(cart);
    cart.getItems().add(cartItem);
    return cartRepository.save(cart);
  }

  @Override
  public Cart removeItemFromCart(Long cartId, Long itemId) {
    Cart cart = getCartById(cartId);
    cart.getItems().removeIf(item -> item.getId().equals(itemId));
    return cartRepository.save(cart);
  }
}
