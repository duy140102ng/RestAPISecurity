package com.ra.model.dto.request;

import com.ra.model.entity.Product;
import com.ra.model.entity.User;
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
public class WishListRequest {
    @NotNull(message = "product_id không đuược null")
    @NotEmpty(message = "product_id không được rỗng")
    @NotBlank(message = "product_id không được để trống")
    private Product product_id;
    @NotNull(message = "User_id không đuược null")
    @NotEmpty(message = "User_id không được rỗng")
    @NotBlank(message = "User_id không được để trống")
    private User user_id;
}
