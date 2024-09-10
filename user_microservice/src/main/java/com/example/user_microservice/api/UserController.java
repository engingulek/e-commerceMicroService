package com.example.user_microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_microservice.business.abstracts.UserService;
import com.example.user_microservice.entity.User;

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
    public User registerUser(@RequestBody @Validated  User user){
        userService.registerUser(user);
        return user;
    }
}
