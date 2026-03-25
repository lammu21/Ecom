package com.ecom.productservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @Document(collection = "products")
@Document(collection = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    private String productId;
    private String productName;
    private String category;
    
    private BigDecimal price;
    private int quantity;
    private String currency;

    private String description;
    private List<String> images;
    private Map<String,Object> specifications;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    

}
