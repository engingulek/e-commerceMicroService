package com.example.product_microservice.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name= "products")
@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "imageurl")
    private List<String> imageUrl;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "sub_category_id")
    private Integer subCategoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "screen_size",precision = 38, scale = 2)
    private BigDecimal screenSize;

    @Column(name = "resolution", length = 20)
    private String resolution;

    @OneToMany(mappedBy="product")
    List<SmartPhone> subProducts;
}
