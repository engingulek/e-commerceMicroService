package com.example.user_microservice.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.user_microservice.business.abstracts.UserService;
import com.example.user_microservice.core.results.ErrorResult;
import com.example.user_microservice.core.results.Result;
import com.example.user_microservice.core.results.SuccessDataResult;
import com.example.user_microservice.dataAccess.UserRepository;
import com.example.user_microservice.dto.request.UserLoginRequest;
import com.example.user_microservice.dto.request.UserRegisterRequest;
import com.example.user_microservice.dto.response.UserResponse;
import com.example.user_microservice.entity.User;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class UserManager implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Result>  registerUser(UserRegisterRequest userRequest) {
        Optional<User> emailState = userRepository.findByEmail(userRequest.getEmail());
        if (emailState.isPresent()){
            return  ResponseEntity.status(401).body(new ErrorResult("This email is already in use"));
        }
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setLastName(userRequest.getLastName());
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
       User createdUser = userRepository.save(user);
       UserResponse userResponse = new UserResponse();
       userResponse.setId(createdUser.getId());
       return ResponseEntity.ok(new SuccessDataResult<>(userResponse, true, "register successful"));
    }

    @Override
    public ResponseEntity<Result> login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByEmail(userLoginRequest.getEmail())
        .filter(u -> u.getPassword().equals(userLoginRequest.getPassword()))
        .orElse(null);
        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            return ResponseEntity.ok(new SuccessDataResult<>(userResponse, true, "login successful"));
        }
        return ResponseEntity.status(401).body(new ErrorResult("invalid password or email"));
    
    }


    
}

    