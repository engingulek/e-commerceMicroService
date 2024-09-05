package com.example.category_microservice.buisness.abstracts;

import java.util.List;

import com.example.category_microservice.dto.response.GetCategoryResponse;

public interface CategoryService {
List<GetCategoryResponse> getAllCategoryRepResponses();
}
