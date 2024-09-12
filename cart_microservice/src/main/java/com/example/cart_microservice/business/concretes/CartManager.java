package com.example.cart_microservice.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cart_microservice.business.abstracts.CartService;
import com.example.cart_microservice.client.ProductClient;
import com.example.cart_microservice.core.modeMapper.ModelMapperService;
import com.example.cart_microservice.core.results.Result;
import com.example.cart_microservice.core.results.SuccessDataResult;
import com.example.cart_microservice.core.results.SuccessResult;
import com.example.cart_microservice.dataAccess.CartItemRepository;
import com.example.cart_microservice.dataAccess.CartRepository;
import com.example.cart_microservice.dto.request.CartIncAndDecRequest;
import com.example.cart_microservice.dto.request.CartRequest;
import com.example.cart_microservice.dto.response.GetBaseProductResponse;
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
    @Autowired
    private  ProductClient productClient;
    @Override
    public ResponseEntity<Result> getCartByUserId(String user_id) {

       Cart cart = cartRepository.findByUserId(user_id);

       List<GetBaseProductResponse> productList = productClient
       .getAll();


       
       List<GetCartByUserIdReponse> getCartByUserIdReponseTst2 = cart
       .getCartItems()
       .stream()
       .map((cartItem) -> {
        GetCartByUserIdReponse response = new GetCartByUserIdReponse();
        response.setId(cartItem.getId());
        response.setProductId(cartItem.getProductId());
        response.setSubProductId(cartItem.getSubProductId());
        response.setQuantity(cartItem.getQuantity());
        productList.forEach( pl ->{
            if (pl.getId() == cartItem.getProductId() && pl.getSub_product_id() == cartItem.getSubProductId()){
                response.setName(pl.getName());
                response.setImageUrl(pl.getImageurl());
                response.setPrice(pl.getPrice());
            } 
        }
        );
        return  response;
       })
       .collect(Collectors.toList());


       
       return  ResponseEntity.ok(new SuccessDataResult<>(getCartByUserIdReponseTst2, true, "fetch successful"));

    }
    @Override
    public ResponseEntity<Result> addProductToCart(CartRequest cartRequest) {
        Cart cartState = cartRepository.findByUserId(cartRequest.getUser_id());
        if (cartState == null){
            Cart newCart = new Cart();
            newCart.setUserId(cartRequest.getUser_id());
            newCart.setCreated_at(new Date());
            newCart.setUpdated_at(new Date());
            Cart  addedCart = cartRepository.save(newCart);

            CartItem  newCartItem = new  CartItem();
            newCartItem.setCart(addedCart);

            newCartItem.setProductId(cartRequest.getProduct_id());
            newCartItem.setSubProductId(cartRequest.getSub_product_id());
            newCartItem.setQuantity(1);
            cartItemRepository.save(newCartItem);
        }else{

            CartItem cartItem = cartItemRepository.findByProductIdAndSubProductId(cartRequest.getProduct_id(),cartRequest.getSub_product_id());

            if(cartItem == null){
                CartItem newCartItem = new CartItem();
                cartState.setUpdated_at(new Date());
                //newCartItem.setCart(cartState);
               newCartItem.getCart().setId(cartState.getId());
               newCartItem.setProductId(cartRequest.getProduct_id());
               newCartItem.setSubProductId(cartRequest.getSub_product_id());
            }else{
                int newQuantity = cartItem.getQuantity() + 1;
                cartItem.setQuantity(newQuantity);
                cartItemRepository.save(cartItem);
                cartState.setUpdated_at(new Date());
            }
            cartRepository.save(cartState);

            
        }
        return  ResponseEntity.ok(new SuccessResult("fetch successful"));
    }
    @Override
    public ResponseEntity<Result> incrementProduct(CartIncAndDecRequest cartIncAndDecRequest) {
        CartItem cartItem = cartItemRepository.findById(cartIncAndDecRequest.getId()).orElseThrow();
        int oldQuantity = cartItem.getQuantity() + 1;
        cartItem.setQuantity(oldQuantity);

        cartItem.getCart().setUpdated_at(new Date());
        cartItemRepository.save(cartItem);
        return  ResponseEntity.ok(new SuccessResult("increment successful"));
    }
    @Override
    public ResponseEntity<Result> decrementProduct(CartIncAndDecRequest cartIncAndDecRequest) {
        CartItem cartItem = cartItemRepository.findById(cartIncAndDecRequest.getId()).orElseThrow();
        if (cartItem.getQuantity() == 1) {
            cartItemRepository.deleteById(cartIncAndDecRequest.getId());
            int cartCount = cartRepository.findAll().size();
            if(cartCount == 1){
                cartRepository.deleteById(cartItem.getCart().getId());
            }else{
                cartItem.getCart().setUpdated_at(new Date());
                cartRepository.save(cartItem.getCart());
            }
            
        }else{
            int newQuantity = cartItem.getQuantity() - 1;
            cartItem.setQuantity(newQuantity);
            cartItem.getCart().setUpdated_at(new Date());
            cartItemRepository.save(cartItem);
        }
       

        return  ResponseEntity.ok(new SuccessResult("increment successful"));
    }
    
}
