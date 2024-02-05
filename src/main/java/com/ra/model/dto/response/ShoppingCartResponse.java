package com.ra.model.dto.response;

import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShoppingCartResponse {
    private Integer id;
    private Product product_id;
    private User user_id;
    private Integer quantity;
}
