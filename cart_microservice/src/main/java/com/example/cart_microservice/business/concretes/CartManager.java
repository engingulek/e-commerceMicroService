package com.example.cart_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cart_microservice.business.abstracts.CartService;
import com.example.cart_microservice.core.modeMapper.ModelMapperService;
import com.example.cart_microservice.dataAccess.CartRepository;
import com.example.cart_microservice.dto.response.GetCartByUserIdReponse;
import com.example.cart_microservice.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CartManager implements  CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public List<GetCartByUserIdReponse> getCartByUserId(String user_id) {
        List<Cart> carts = cartRepository.findByUserId(user_id);
        List<GetCartByUserIdReponse> getCartByUserIdReponse = carts.stream()
        .map(cart -> this.modelMapperService.forResponse()
        .map(cart, GetCartByUserIdReponse.class)).collect(Collectors.toList());
        return  getCartByUserIdReponse;
        
    }
    
}
