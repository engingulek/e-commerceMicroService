package com.example.product_microservice.entity;

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
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
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

    @OneToMany(mappedBy="product")
    List<SmartPhone> smartPhones;
    @OneToMany(mappedBy="product")
    List<Laptop> laptops;

    @OneToMany(mappedBy="product")
    List<Clothes> clothes;


    
}
