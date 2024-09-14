package com.example.category_microservice.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.category_microservice.business.abstracts.CategoryService;
import com.example.category_microservice.core.mapper.ModelMapperService;
import com.example.category_microservice.core.results.ErrorResult;
import com.example.category_microservice.core.results.Result;
import com.example.category_microservice.core.results.SuccessDataResult;
import com.example.category_microservice.dataAccess.CategoryRepository;
import com.example.category_microservice.dto.response.GetCategoryResponse;
import com.example.category_microservice.entities.Category;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryManager implements  CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired private ModelMapperService modelMapperService;
    @Override
    public ResponseEntity<Result> getAllCategoryRepResponses() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.status(500)
            .body(new ErrorResult("Something went wrong"));
        }
        else {
            List<GetCategoryResponse> list = categories.stream().map(a -> this.modelMapperService.forResponse()
            .map(a, GetCategoryResponse.class)).collect(Collectors.toList());
         
            return  ResponseEntity.ok( new SuccessDataResult<>(list, "successful fetching"));
        }
    }

}
