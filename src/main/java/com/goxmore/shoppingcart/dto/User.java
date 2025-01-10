package com.goxmore.shoppingcart.dto;

import java.time.LocalDateTime;

public class User {
  private Long id;
  private String name;
  private String email;
  private LocalDateTime emailVerified;
  private String image;
  private String password;

  public User() {
  }

  public User(Long id, String name, String email, LocalDateTime emailVerified, String image, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.emailVerified = emailVerified;
    this.image = image;
    this.password = password;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getEmailVerified() {
    return this.emailVerified;
  }

  public void setEmailVerified(LocalDateTime emailVerified) {
    this.emailVerified = emailVerified;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
