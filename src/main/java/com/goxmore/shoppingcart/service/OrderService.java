package com.goxmore.shoppingcart.service;

import java.util.List;

import com.goxmore.shoppingcart.model.Order;

public interface OrderService {
  public Order createOrder(Long userId);

  public Order getOrderById(Long orderId);

  public List<Order> getOrderByUserId(Long userId);

  public List<Order> getAllOrders();

  public Order placeOrder(Long cartId, String shippingAddress);
}