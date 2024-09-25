package com.example.cart_microservice.business.abstracts;

import org.springframework.http.ResponseEntity;

import com.example.cart_microservice.core.results.Result;
import com.example.cart_microservice.dto.request.CartIncAndDecRequest;
import com.example.cart_microservice.dto.request.CartRequest;

public interface  CartService {
   ResponseEntity<Result> getCartByUserId(String user_id);
   ResponseEntity<Result> addProductToCart(CartRequest cartRequest);
   ResponseEntity<Result> incrementProduct(CartIncAndDecRequest cartIncAndDecRequest);
   ResponseEntity<Result> decrementProduct(CartIncAndDecRequest cartIncAndDecRequest);
}
