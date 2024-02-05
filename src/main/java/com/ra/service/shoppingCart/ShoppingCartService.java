package com.ra.service.shoppingCart;

import com.ra.model.dto.request.ShoppingCartRequest;
import com.ra.model.dto.response.ShoppingCartResponse;
import com.ra.model.entity.Shopping_Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShoppingCartService {
    Page<ShoppingCartResponse> getAll(Pageable pageable);
    Shopping_Cart save(Shopping_Cart shoppingCart);
    Shopping_Cart findById(Integer id);
    void delete(Long id);
    void deleteAllProduct();
    Shopping_Cart convertShoppingCartRequestToShoppingCart(ShoppingCartRequest shoppingCartRequest);
    ShoppingCartResponse convertShoppingCartToShoppingCartResponse(Shopping_Cart shoppingCart);
}
