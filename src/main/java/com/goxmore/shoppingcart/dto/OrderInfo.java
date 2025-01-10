package com.goxmore.shoppingcart.dto;

public class OrderInfo {
  private Long cartId;
  private String shippingAddress;

  public OrderInfo() {
  }

  public OrderInfo(Long cartId, String shippingAddress) {
    this.cartId = cartId;
    this.shippingAddress = shippingAddress;
  }

  public Long getCartId() {
    return this.cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }

  public String getShippingAddress() {
    return this.shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

}
