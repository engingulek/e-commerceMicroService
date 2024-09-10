package com.example.user_microservice.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_microservice.business.abstracts.UserService;
import com.example.user_microservice.dataAccess.UserRepository;
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
    public User registerUser(User user) {
        userRepository.save(user);
        return  userRepository.save(user);
    }


    
}
