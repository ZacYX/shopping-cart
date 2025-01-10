package com.goxmore.shoppingcart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goxmore.shoppingcart.model.Cart;
import com.goxmore.shoppingcart.model.CartItem;
import com.goxmore.shoppingcart.model.Order;
import com.goxmore.shoppingcart.model.OrderItem;
import com.goxmore.shoppingcart.repository.CartRepository;
import com.goxmore.shoppingcart.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final CartRepository cartRepository;

  public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
    this.orderRepository = orderRepository;
    this.cartRepository = cartRepository;
  }

  @Override
  public Order createOrder(Long userId) {
    Order order = new Order();
    order.setUserId(userId);
    return orderRepository.save(order);
  }

  @Override
  public Order getOrderById(Long orderId) {
    return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
  }

  @Override
  public List<Order> getOrderByUserId(Long userId) {
    return orderRepository.findByUserId(userId);
  }

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order placeOrder(Long cartId, String shippingAddress) {
    try {
      Optional<Cart> optCart = cartRepository.findById(cartId);
      if (!optCart.isPresent()) {
        System.out.println("cart not found");
        return null;
      }
      Cart cart = optCart.get();
      Order order = new Order(cart.getUserId(), shippingAddress);
      BigDecimal totalAmount = new BigDecimal(0);
      List<OrderItem> items = new ArrayList<OrderItem>();
      for (CartItem item : cart.getItems()) {
        items.add(new OrderItem(order, item.getProductId(), item.getQuantity(), item.getPrice()));
        totalAmount = totalAmount.add(item.getPrice());
      }
      order.setTotalAmount(totalAmount);
      order.setItems(items);
      order = orderRepository.save(order);
      cart.getItems().clear();
      cartRepository.save(cart);

      return order;
    } catch (Exception e) {
      System.out.println("Exception caught: " + e.getMessage());
    }
    return null;
  }

}
