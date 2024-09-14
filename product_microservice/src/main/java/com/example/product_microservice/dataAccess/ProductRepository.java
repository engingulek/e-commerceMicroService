package com.example.product_microservice.dataAccess;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.product_microservice.dto.clothes.GetClothesResponse;
import com.example.product_microservice.entity.Product;
public interface  ProductRepository extends JpaRepository<Product, Integer>{

List<Product> findBySubCategoryId(int sub_category_id);

//@Query("Select new com.example.product_microservice.dto.clothes.GetClothesResponse(p.name,c.price,cc.name) from Product as p join Clothes as c on p.id = c.product.id join ClotheColor as cc on c.clotheColor.id = cc.id Where p.subCategoryId=:subCategoryId  group by  p.id, c.id, p.imageUrl, p.name, c.price, cc.name ")
@Query("Select new com.example.product_microservice.dto.clothes.GetClothesResponse(p.id,p.imageUrl,p.name, c.price, cc) FROM Product p " +
           "JOIN Clothes c ON p.id = c.product.id " +
           "JOIN ClotheColor cc ON c.clotheColor.id = cc.id " +
           "WHERE p.subCategoryId = :subCategoryId " +
           "GROUP BY p.id,p.imageUrl,p.name, c.price, cc")
List<GetClothesResponse> findBySubCategoryIdForClothes(int subCategoryId);



/*@Query(value = "SELECT p.id,p.name FROM products p JOIN smart_phones s on s.product_id = p.id WHERE s.product_id = :sub_product_id AND s.id = :id group by  p.id,p.name Limit 1", nativeQuery=true)
List<Product> findSmartPhoneDetail(@Param("id") int id,@Param("sub_product_id") int sub_product_id);*/






}