package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Products;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAll() {
        List<Products> products = productRepository.findAll();
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }
}
