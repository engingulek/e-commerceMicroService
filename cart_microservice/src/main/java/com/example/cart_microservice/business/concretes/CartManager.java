package com.example.cart_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cart_microservice.business.abstracts.CartService;
import com.example.cart_microservice.core.modeMapper.ModelMapperService;
import com.example.cart_microservice.core.results.Result;
import com.example.cart_microservice.core.results.SuccessDataResult;
import com.example.cart_microservice.core.results.SuccessResult;
import com.example.cart_microservice.dataAccess.CartItemRepository;
import com.example.cart_microservice.dataAccess.CartRepository;
import com.example.cart_microservice.dto.request.CartRequest;
import com.example.cart_microservice.dto.response.GetCartByUserIdReponse;
import com.example.cart_microservice.entity.Cart;
import com.example.cart_microservice.entity.CartItem;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CartManager implements  CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired 
    private CartItemRepository cartItemRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public ResponseEntity<Result> getCartByUserId(String user_id) {
       Cart cart = cartRepository.findByUserId(user_id);
       List<GetCartByUserIdReponse> getCartByUserIdReponse = cart
       .getCartItems()
       .stream()
       .map(cartItem -> this.modelMapperService.forResponse()
       .map(cartItem, GetCartByUserIdReponse.class))
       .collect(Collectors.toList());

       return  ResponseEntity.ok(new SuccessDataResult<>(getCartByUserIdReponse, true, "fetch successful"));

    }
    @Override
    public ResponseEntity<Result> addProductToCart(CartRequest cartRequest) {
        Cart cartState = cartRepository.findByUserId(cartRequest.getUser_id());
        if (cartState == null){
            Cart newCart = new Cart();
            newCart.setUserId(cartRequest.getUser_id());
            Cart  addedCart = cartRepository.save(newCart);
            CartItem  newCartItem = new  CartItem();
            newCartItem.setId(addedCart.getId());
            newCartItem.setProductId(cartRequest.getProduct_id());
            newCartItem.setQuantity(1);
            cartItemRepository.save(newCartItem);
        }else{

            CartItem cartItem = cartItemRepository.findByProductId(cartRequest.getProduct_id());

            if(cartItem == null){
                CartItem newCartItem = new CartItem();
                newCartItem.setCart(cartState);
               // newCartItem.getCart().setId(cartState.getId());
               newCartItem.setProductId(cartRequest.getProduct_id());
            }else{
                int newQuantity = cartItem.getQuantity() + 1;
                cartItem.setQuantity(newQuantity);
                cartItemRepository.save(cartItem);
            }
            
        }
        return  ResponseEntity.ok(new SuccessResult("fetch successful"));
    }
    
}
