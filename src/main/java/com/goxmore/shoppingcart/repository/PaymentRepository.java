package com.goxmore.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goxmore.shoppingcart.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
