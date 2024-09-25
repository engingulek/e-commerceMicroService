package com.example.category_microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category_microservice.business.abstracts.CategoryService;
import com.example.category_microservice.core.results.Result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("api/category/")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return  categoryService.getAllCategoryRepResponses();
    }
    
}
