package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.repository.CategoryRepository;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductResponse::new);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product products) {
        return productRepository.save(products);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductByCategoryId(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return productRepository.findProductsByCategory(category);
    }
    @Override
    public List<Product> findByProductNameOrDescription(String search) {
        return productRepository.findByProductNameContainingOrDescriptionContaining(search, search);
    }
}
