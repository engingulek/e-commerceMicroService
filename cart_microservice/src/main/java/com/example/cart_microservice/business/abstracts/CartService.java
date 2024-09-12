package com.example.cart_microservice.business.abstracts;

import java.util.List;

import com.example.cart_microservice.dto.response.GetCartByUserIdReponse;

public interface  CartService {
    List<GetCartByUserIdReponse> getCartByUserId(String user_id);
}
