package com.example.inventory_microservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "items" )
public class Item {
    @Id
    private String id;
    @Field(name = "product_id")
    private int productId;
    private  int  color_id;
    private  int  memory_size_id;
    private int stock_quantity;

}
