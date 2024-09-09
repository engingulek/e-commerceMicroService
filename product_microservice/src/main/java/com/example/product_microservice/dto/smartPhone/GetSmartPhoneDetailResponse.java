package com.example.product_microservice.dto.smartPhone;



import com.example.product_microservice.dto.baseProduct.GetBaseProductDetailResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetSmartPhoneDetailResponse extends  GetBaseProductDetailResponse {
    
    private int color_id;
    private int  memory_size_id;
}
