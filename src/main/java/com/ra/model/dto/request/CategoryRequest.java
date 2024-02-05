package com.ra.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CategoryRequest {
    @NotNull(message = "CategoryName không đuược null")
    @NotEmpty(message = "CategoryName không được rỗng")
    @NotBlank(message = "CategoryName không được để trống")
    private String categoryName;
}
