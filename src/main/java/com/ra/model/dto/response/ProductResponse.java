package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
    private Long id;
    private Long sku;
    private String productName;
    private String description;
    private Double price;
    private Integer stock_quantity;
    private String image;
    private Category category;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    public ProductResponse(Product products) {
        this.id = products.getId();
        this.sku = products.getSku();
        this.productName = products.getProductName();
        this.description = products.getDescription();
        this.price = products.getPrice();
        this.stock_quantity = products.getStock_quantity();
        this.image = products.getImage();
        this.category = products.getCategory();
        this.created_at = products.getCreated_at();
        this.update_at = products.getUpdated_at();
    }
}
