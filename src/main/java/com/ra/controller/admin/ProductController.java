package com.ra.controller.admin;

import com.ra.model.entity.Products;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Products> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
