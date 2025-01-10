package com.goxmore.shoppingcart.dto;

import java.time.LocalDateTime;

public class Product {
  private Long id;
  private String sku;
  private String name;
  private String details;
  private String brand;
  private Long inventory;
  private Float price;
  private Float salePrice;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;

  public Product() {
  }

  public Product(Long id, String sku, String name, String details, String brand, Long inventory, Float price,
      Float salePrice, LocalDateTime createAt, LocalDateTime updateAt) {
    this.id = id;
    this.sku = sku;
    this.name = name;
    this.details = details;
    this.brand = brand;
    this.inventory = inventory;
    this.price = price;
    this.salePrice = salePrice;
    this.createAt = createAt;
    this.updateAt = updateAt;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSku() {
    return this.sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDetails() {
    return this.details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Long getInventory() {
    return this.inventory;
  }

  public void setInventory(Long inventory) {
    this.inventory = inventory;
  }

  public Float getPrice() {
    return this.price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Float getSalePrice() {
    return this.salePrice;
  }

  public void setSalePrice(Float salePrice) {
    this.salePrice = salePrice;
  }

  public LocalDateTime getCreateAt() {
    return this.createAt;
  }

  public void setCreateAt(LocalDateTime createAt) {
    this.createAt = createAt;
  }

  public LocalDateTime getUpdateAt() {
    return this.updateAt;
  }

  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }

}
