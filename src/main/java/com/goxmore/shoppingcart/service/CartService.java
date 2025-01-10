package com.goxmore.shoppingcart.service;

import java.util.List;

import com.goxmore.shoppingcart.model.Cart;
import com.goxmore.shoppingcart.model.CartItem;

public interface CartService {
  public List<Cart> getAllCarts();

  public Cart createCart(Long userId);

  public Cart getCartByUserId(Long userId);

  public Cart getCartById(Long cartId);

  public Cart addItemToCart(Long cartId, CartItem cartItem);

  public Cart removeItemFromCart(Long CartId, Long itemId);

}
