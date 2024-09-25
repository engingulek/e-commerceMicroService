package com.example.user_microservice.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_microservice.entity.User;

public interface UserRepository extends  JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
