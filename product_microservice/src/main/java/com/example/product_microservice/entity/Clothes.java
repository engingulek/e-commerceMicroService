package com.example.product_microservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name= "clothes")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    
    @OneToOne
    @JoinColumn(name = "color_id")
    private ClotheColor clotheColor;
    
    @OneToOne
    @JoinColumn(name="size_id")
    private ClotheSize clotheSize;

    @Column(name = "price",precision = 3, scale = 2)
    private BigDecimal price;


}
