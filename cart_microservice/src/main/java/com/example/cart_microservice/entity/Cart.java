package com.example.cart_microservice.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "cart")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id",nullable = false)
    private String userId;

    @Column(name="created_at",nullable = false)
    private Date created_at;
    @Column(name="updated_at",nullable = false)
    private Date updated_at;

    @OneToMany(mappedBy="cart")
    List<CartItem> cartItems;
}
