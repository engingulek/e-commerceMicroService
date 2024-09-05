package com.example.category_microservice.buisness.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category_microservice.buisness.abstracts.CategoryService;
import com.example.category_microservice.core.mapper.ModelMapperService;
import com.example.category_microservice.dataAccess.CategoryRepository;
import com.example.category_microservice.dto.response.GetCategoryResponse;
import com.example.category_microservice.dto.response.GetSubCategoryResponse;
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
    public List<GetCategoryResponse> getAllCategoryRepResponses() {
        List<Category> categories = categoryRepository.findAll();

        List<GetCategoryResponse> list =  categories.stream().map(category -> {

            GetCategoryResponse categoryResponse = modelMapperService
            .forResponse()
            .map(category, GetCategoryResponse.class);

            List<GetSubCategoryResponse> subCategoryResponses = category
            .getSubCategories()
            .stream()
            .map(subCategory -> modelMapperService
                .forResponse()
                 .map(subCategory, GetSubCategoryResponse.class))
            .collect(Collectors.toList());
            
            categoryResponse.setSubCategories(subCategoryResponses);

            return categoryResponse;
        }).collect(Collectors.toList());

        return  list;
    }

}
