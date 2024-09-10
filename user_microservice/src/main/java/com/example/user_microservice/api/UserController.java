package com.example.user_microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_microservice.business.abstracts.UserService;
import com.example.user_microservice.core.results.Result;
import com.example.user_microservice.dto.request.UserLoginRequest;
import com.example.user_microservice.dto.request.UserRegisterRequest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/user/")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<Result>  registerUser(@RequestBody @Validated UserRegisterRequest userRequest){
      return  userService.registerUser(userRequest);
    }

    @PostMapping("login")
    public ResponseEntity<Result> login(@RequestBody @Validated UserLoginRequest userLoginRequest){
      return userService.login(userLoginRequest);
    }
}
