package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductResponse> getAll(Pageable pageable);
    Product findById(Long id);
    Product save(Product products);
    void delete(Long id);
    List<Product> findByProductNameOrDescription(String search);
    List<Product> findProductByCategoryId(Long id);
}
