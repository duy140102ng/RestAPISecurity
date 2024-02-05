package com.ra.model.dto.request;

import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailRequest {
    @NotNull(message = "order_id không đuược null")
    @NotEmpty(message = "order_id không được rỗng")
    @NotBlank(message = "order_id không được để trống")
    private Orders order_id;
    @NotNull(message = "product_id không đuược null")
    @NotEmpty(message = "product_id không được rỗng")
    @NotBlank(message = "product_id không được để trống")
    private Product product_id;
    @NotNull(message = "name không đuược null")
    @NotEmpty(message = "name không được rỗng")
    @NotBlank(message = "name không được để trống")
    private String name;
    @NotNull(message = "price không đuược null")
    @NotEmpty(message = "price không được rỗng")
    @NotBlank(message = "price không được để trống")
    private Float price;
    @NotNull(message = "quantity không đuược null")
    @NotEmpty(message = "quantity không được rỗng")
    @NotBlank(message = "quantity không được để trống")
    @Min(0)
    private Integer quantity;
}
