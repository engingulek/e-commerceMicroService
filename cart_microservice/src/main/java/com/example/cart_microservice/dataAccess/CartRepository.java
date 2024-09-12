package com.example.cart_microservice.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cart_microservice.entity.Cart;

public interface  CartRepository extends  JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(String user_id);
}
