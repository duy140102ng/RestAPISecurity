package com.ra.controller.admin;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Hiển thị phân trang
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5", name = "limit") int limit,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "categoryName", name = "sort") String sort,
            @RequestParam(defaultValue = "asc", name = "order") String order
    ) {
        Pageable pageable;
        if (order.equals("asc")) {
            pageable = PageRequest.of(page, limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, limit, Sort.by(sort).descending());
        }
        Page<CategoryResponse> categoryResponses = categoryService.getAll(pageable);
        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }
//Thêm mới danh mục
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Category category){
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<>(categoryNew, HttpStatus.CREATED);
    }
    //Lấy thông tin danh mục theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Category categories = categoryService.findById(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    //Update danh mục
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Category category){
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<>(categoryNew, HttpStatus.OK);
    }
    //Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

