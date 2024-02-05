package com.ra.repository;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByProductNameContainingOrDescriptionContaining(String productName, String description);
    public List<Product> findProductsByCategory(Category category);
}
