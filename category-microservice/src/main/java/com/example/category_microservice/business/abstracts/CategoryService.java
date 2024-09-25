package com.example.category_microservice.business.abstracts;

import org.springframework.http.ResponseEntity;

import com.example.category_microservice.core.results.Result;

public interface CategoryService {
    ResponseEntity<Result> getAllCategoryRepResponses();
}
