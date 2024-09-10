package com.example.user_microservice.business.abstracts;

import org.springframework.http.ResponseEntity;

import com.example.user_microservice.core.results.Result;
import com.example.user_microservice.dto.request.UserLoginRequest;
import com.example.user_microservice.dto.request.UserRegisterRequest;

public interface UserService  {
    ResponseEntity<Result>  registerUser(UserRegisterRequest userRequest);
    ResponseEntity<Result>  login(UserLoginRequest userLoginRequest);
    
}
