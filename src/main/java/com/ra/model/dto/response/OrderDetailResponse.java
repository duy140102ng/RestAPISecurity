package com.ra.model.dto.response;

import com.ra.model.entity.OrderDetails;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDetailResponse {
    private Long id;
    private Orders order_id;
    private Product product_id;
    private String name;
    private Float price;
    private Integer quantity;
    public OrderDetailResponse(OrderDetails orderDetails){
        this.id = orderDetails.getId();
        this.order_id = orderDetails.getOrder_id();
        this.product_id = orderDetails.getProduct_id();
        this.name = orderDetails.getName();
        this.price = orderDetails.getPrice();
        this.quantity = orderDetails.getQuantity();
    }
}
