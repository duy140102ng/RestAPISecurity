package com.ra.model.dto.request;

import com.ra.model.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    @NotNull(message = "ProductName không đuược null")
    @NotEmpty(message = "ProductName không được rỗng")
    @NotBlank(message = "ProductName không được để trống")
    private String productName;
    private Double price;
    @NotNull(message = "stock_quantity không đuược null")
    @NotBlank(message = "stock_quantity không được để trống")
    @Min(0)
    private Integer stock_quantity;
}
