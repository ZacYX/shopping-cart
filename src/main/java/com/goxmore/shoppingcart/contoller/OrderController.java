package com.goxmore.shoppingcart.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goxmore.shoppingcart.dto.OrderInfo;
import com.goxmore.shoppingcart.model.Order;
import com.goxmore.shoppingcart.service.OrderService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/apishopping/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Order>> getAllOrders() {
    return ResponseEntity.ok(orderService.getAllOrders());
  }

  @PostMapping("/placeorder")
  public ResponseEntity<Order> placeOrder(@RequestBody OrderInfo orderInfo) {
    return ResponseEntity.ok(orderService.placeOrder(orderInfo.getCartId(), orderInfo.getShippingAddress()));
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
    return ResponseEntity.ok(orderService.getOrderById(orderId));
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable Long userId) {
    return ResponseEntity.ok(orderService.getOrderByUserId(userId));
  }

}
