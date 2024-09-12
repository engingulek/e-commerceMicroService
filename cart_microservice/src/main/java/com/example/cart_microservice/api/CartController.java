package com.example.cart_microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart_microservice.business.abstracts.CartService;
import com.example.cart_microservice.dto.response.GetCartByUserIdReponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/cart/")
@AllArgsConstructor
@NoArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("cartByUserId")
    public List<GetCartByUserIdReponse> getCartByUserId(@RequestParam String userId){
        return  cartService.getCartByUserId(userId);
    }
}
