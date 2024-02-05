package com.ra.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLogin {
    @NotNull(message = "UserName không đuược null")
    @NotEmpty(message = "UserName không được rỗng")
    @NotBlank(message = "UserName không được để trống")
//    @Size // dùng cho chuỗi
//    @Length // dùng cho chuỗi
//    @Min() // dùng cho số
//    @Max() // dùng cho số
//    @Pattern() // dùng pattern để validate
    private String userName;

    @NotNull(message = "password không đuược null")
    @NotEmpty(message = "password không được rỗng")
    @NotBlank(message = "password không được để trống")
    private String passWord;
}
