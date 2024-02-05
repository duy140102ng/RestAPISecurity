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
public class AddressRequest {
    @NotNull(message = "User_id không đuược null")
    @NotEmpty(message = "User_id không được rỗng")
    @NotBlank(message = "User_id không được để trống")
    private User user_id;
    @NotNull(message = "fullAddress không đuược null")
    @NotEmpty(message = "fullAddress không được rỗng")
    @NotBlank(message = "fullAddress không được để trống")
    private String fullAddress;
    @NotNull(message = "phone không đuược null")
    @NotEmpty(message = "phone không được rỗng")
    @NotBlank(message = "phone không được để trống")
    private String phone;
    @NotNull(message = "receiveName không đuược null")
    @NotEmpty(message = "receiveName không được rỗng")
    @NotBlank(message = "receiveName không được để trống")
    private String receiveName;
}
