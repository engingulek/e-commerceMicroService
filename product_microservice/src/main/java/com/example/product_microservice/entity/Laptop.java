package com.example.product_microservice.entity;



import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name= "laptops")
@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id; 
     @Column(name = "price",precision = 38, scale = 2)
    private BigDecimal price;
    @Column(name = "memory_size_id")
    private int memory_size_id;
    @Column(name = "battery_capacity")
    private String battery_capacity;
    @Column(name = "ram_capacity")
    private int ram_capacity;
    @Column(name = "operating_system")
    private String operating_system;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
