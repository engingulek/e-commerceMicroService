package com.example.product_microservice.dataAccess;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.product_microservice.dto.clothes.GetClothesDto;
import com.example.product_microservice.entity.Product;
public interface  ProductRepository extends JpaRepository<Product, Integer>{

List<Product> findBySubCategoryId(int sub_category_id);

@Query("Select new com.example.product_microservice.dto.clothes.GetClothesDto(p.id,p.imageUrl,Concat(p.name ,' ' ,cc.name ), c.price, cc.id)" +
           "FROM Product p " +
           "JOIN Clothes c ON p.id = c.product.id " +
           "JOIN ClotheColor cc ON c.clotheColor.id = cc.id " +
           "WHERE p.subCategoryId = :subCategoryId " +
           "GROUP BY p.id,p.imageUrl,p.name, c.price, cc.id,cc.name")
List<GetClothesDto> findBySubCategoryIdForClothes(int subCategoryId);
}