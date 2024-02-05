package com.ra.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegister {
    @NotNull(message = "Fullname không đuược null")
    @NotEmpty(message = "Fullname không được rỗng")
    @NotBlank(message = "Fullname không được để trống")
    private String fullName;
    @NotNull(message = "UserName không đuược null")
    @NotEmpty(message = "UserName không được rỗng")
    @NotBlank(message = "UserName không được để trống")
    private String userName;
    @NotNull(message = "password không đuược null")
    @NotEmpty(message = "password không được rỗng")
    @NotBlank(message = "password không được để trống")
    private String passWord;
    @NotBlank(message = "email không được để trống")
    @Email(message = "email không đúng định dạng")
    private String email;
    private Boolean status;
    private String avatar;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^\\+?[0-9]+$", message = "Số điện thoại không đúng định dạng")
    private String phone;
    @NotNull(message = "Địa chỉ không đuược null")
    @NotEmpty(message = "Địa chỉ không được rỗng")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at;
}
