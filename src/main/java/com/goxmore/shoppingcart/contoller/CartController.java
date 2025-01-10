package com.goxmore.shoppingcart.contoller;

import org.springframework.web.bind.annotation.RestController;

import com.goxmore.shoppingcart.model.Cart;
import com.goxmore.shoppingcart.model.CartItem;
import com.goxmore.shoppingcart.service.CartService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/apishopping/carts")
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Cart>> getAllCarts() {
    return ResponseEntity.ok(cartService.getAllCarts());
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
    return ResponseEntity.ok(cartService.getCartByUserId(userId));
  }

  @PostMapping("/{cartId}/items")
  public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
    return ResponseEntity.ok(cartService.addItemToCart(cartId, cartItem));
  }

  @DeleteMapping("/{cartId}/items/{itemId}")
  public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
    return ResponseEntity.ok(cartService.removeItemFromCart(cartId, itemId));
  }
}
