package com.ra.model.dto.request;

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
public class OrderRequest {
    @NotNull(message = "User_id không đuược null")
    @NotEmpty(message = "User_id không được rỗng")
    @NotBlank(message = "User_id không được để trống")
    private User user_id;
    @NotNull(message = "total_price không đuược null")
    @NotEmpty(message = "total_price không được rỗng")
    @NotBlank(message = "total_price không được để trống")
    private Double total_price;
    @NotNull(message = "receive_name không đuược null")
    @NotEmpty(message = "receive_name không được rỗng")
    @NotBlank(message = "receive_name không được để trống")
    private String receive_name;
    @NotNull(message = "receive_address không đuược null")
    @NotEmpty(message = "receive_address không được rỗng")
    @NotBlank(message = "receive_address không được để trống")
    private String receive_address;
    @NotNull(message = "receive_phone không đuược null")
    @NotEmpty(message = "receive_phone không được rỗng")
    @NotBlank(message = "receive_phone không được để trống")
    private String receive_phone;
}
