package com.ra.controller.auth;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Product;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/auth/products")
public class ProductAuth {
    @Autowired
    private ProductService productService;
    //Tìm kiếm sản phẩm theo tên hoặc mô tả
    @PostMapping("/search")
    public ResponseEntity<?> findByName(@PathVariable String search) {
        List<Product> products = productService.findByProductNameOrDescription(search);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //Danh sách sản phẩm mới
    @GetMapping("/new-products")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5", name = "limit") int limit,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "productName", name = "sort") String sort,
            @RequestParam(defaultValue = "desc", name = "order") String order
    ) {
        Pageable pageable;
        if (order.equals("desc")) {
            pageable = PageRequest.of(page, limit, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(page, limit, Sort.by(sort).ascending());
        }
        Page<ProductResponse> productResponses = productService.getAll(pageable);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
    //Danh sách sản phẩm theo danh mục
    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable Long id){
        List<Product> productResponses = productService.findProductByCategoryId(id);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
    //Chi tiết thông tin sản phẩm theo Id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
