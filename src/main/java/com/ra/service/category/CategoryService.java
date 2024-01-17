package com.ra.service.category;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService{
    Page<CategoryResponse> getAll(Pageable pageable);
    Category findById(Long id);
    Category save(Category category);
    void delete(Long id);
}