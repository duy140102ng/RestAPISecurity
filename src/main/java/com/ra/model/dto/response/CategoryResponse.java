package com.ra.model.dto.response;

import com.ra.model.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private String description;
    private Boolean status;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.description = category.getDescription();
        this.status = category.getStatus();
    }
}
