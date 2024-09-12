package com.example.cart_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cart_microservice.entity.CartItem;

public interface  CartItemRepository extends  JpaRepository<CartItem, Integer> {
    CartItem  findByProductId(int product_id);
}
