package com.example.category_microservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category_microservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
