package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import com.ra.model.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
    private Long id;
    private String productName;
    private Double price;
    private String image;
    private Category category;

    public ProductResponse(Products products) {
        this.id = products.getId();
        this.id = products.getId();
        this.productName = products.getProductName();
        this.price = products.getPrice();
        this.image = products.getImage();
        this.category = products.getCategory();
    }
}
