package com.example.category_microservice.entities;

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

@Table(name= "sub_categories")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class SubCategory {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",length = 25, nullable = true)
    private String name;

    @Column(name="icon")
    private String icon;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = true)
    private Category category;
}
