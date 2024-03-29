package com.ra.controller.admin;

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

@RestController
@RequestMapping("/v1/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    //Hiển thị phân trang
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5", name = "limit") int limit,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "productName", name = "sort") String sort,
            @RequestParam(defaultValue = "asc", name = "order") String order
    ) {
        Pageable pageable;
        if (order.equals("asc")) {
            pageable = PageRequest.of(page, limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, limit, Sort.by(sort).descending());
        }
        Page<ProductResponse> productResponses = productService.getAll(pageable);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
    //Thêm mới sản phẩm
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Product products){
        Product productsNew = productService.save(products);
        return new ResponseEntity<>(productsNew, HttpStatus.CREATED);
    }
    //Lấy thông tin sản phẩm theo Id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Product products = productService.findById(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //Update sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product products){
        Product productsNew = productService.save(products);
        return new ResponseEntity<>(productsNew, HttpStatus.OK);
    }
    //Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
