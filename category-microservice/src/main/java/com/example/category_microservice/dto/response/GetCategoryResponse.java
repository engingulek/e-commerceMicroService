package com.example.category_microservice.dto.response;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {
    private int id;
    private  String name;
    private String icon;
    private List<GetSubCategoryResponse> subCategories;
}
