package com.ra.service.shoppingCart;

import com.ra.model.dto.request.ShoppingCartRequest;
import com.ra.model.dto.response.ShoppingCartResponse;
import com.ra.model.entity.Product;
import com.ra.model.entity.Shopping_Cart;
import com.ra.model.entity.User;
import com.ra.repository.ShoppingCartRepository;
import com.ra.security.user_principal.UserPrincipal;
import com.ra.service.product.ProductService;
import com.ra.service.user_role.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartImpl implements ShoppingCartService{
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    private User userLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()){
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            return userService.findById(userPrincipal.getUser().getId());
        }else {
            logger.error("Không tìm thấy người dùng");
            return null;
        }
    }
    private final Logger logger = LoggerFactory.getLogger(ShoppingCartImpl.class);

//    @Override
//    public Page<ShoppingCartResponse> getAll(Pageable pageable) {
//        Page<Shopping_Cart> shoppingCarts = shoppingCartRepository.findAllByUser_id(userLogin(), pageable);
//        return shoppingCarts.map(this::convertShoppingCartToShoppingCartResponse);
//    }

    @Override
    public Page<ShoppingCartResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Shopping_Cart save(Shopping_Cart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Shopping_Cart findById(Integer id) {
        return null;
    }

//    @Override
//    public Shopping_Cart findById(Integer id) {
//        return shoppingCartRepository.findByIdAndUser_id(id, userLogin());
//    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public void deleteAllProduct() {

    }

//    @Transactional
//    @Override
//    public void deleteAllProduct() {
//        shoppingCartRepository.deleteByUser_id(userLogin());
//    }

    @Override
    public Shopping_Cart convertShoppingCartRequestToShoppingCart(ShoppingCartRequest shoppingCartRequest) {
        Product products = productService.findById(shoppingCartRequest.getProduct_id().getId());
        if (products == null){
            throw new RuntimeException();
        }
        return Shopping_Cart.builder()
                .quantity(shoppingCartRequest.getQuantity())
                .product_id(products)
                .user_id(userLogin())
                .build();
    }

    @Override
    public ShoppingCartResponse convertShoppingCartToShoppingCartResponse(Shopping_Cart shoppingCart) {
        return ShoppingCartResponse.builder()
                .product_id(shoppingCart.getProduct_id())
                .user_id(shoppingCart.getUser_id())
                .quantity(shoppingCart.getQuantity())
                .build();
    }
}
