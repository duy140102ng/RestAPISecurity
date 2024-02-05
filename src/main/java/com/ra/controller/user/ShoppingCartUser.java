package com.ra.controller.user;

import com.ra.model.dto.request.ShoppingCartRequest;
import com.ra.model.dto.response.ShoppingCartResponse;
import com.ra.model.entity.Shopping_Cart;
import com.ra.service.product.ProductService;
import com.ra.service.shoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/shopping-cart")
public class ShoppingCartUser {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    //Danh sách sản phẩm trong giỏ hàng
    @GetMapping("")
    public ResponseEntity<?> getAll(
        @RequestParam(defaultValue = "5", name = "limit") int limit,
        @RequestParam(defaultValue = "0", name = "page") int page,
        @RequestParam(defaultValue = "id", name = "sort") String sort){
            Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
            Page<ShoppingCartResponse> shoppingCarts = shoppingCartService.getAll(pageable);
            return new ResponseEntity<>(shoppingCarts, HttpStatus.OK);
    }

    //Thêm mới sản phẩm vào giỏ hàng
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        Shopping_Cart shoppingCart = shoppingCartService.convertShoppingCartRequestToShoppingCart(shoppingCartRequest);
        Shopping_Cart shoppingCartNew = shoppingCartService.save(shoppingCart);
        return new ResponseEntity<>(shoppingCartService.convertShoppingCartToShoppingCartResponse(shoppingCartNew), HttpStatus.CREATED);
    }
    //Thay đổi số lượng đặt hàng
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartResponse> save(@PathVariable Integer id, @RequestBody ShoppingCartRequest shoppingCartRequest){
        Shopping_Cart shoppingCart = shoppingCartService.findById(id);
        if (shoppingCart == null){
            throw new RuntimeException();
        }
        shoppingCart.setQuantity(shoppingCartRequest.getQuantity());
        Shopping_Cart shopping_cart = shoppingCartService.save(shoppingCart);
        return new ResponseEntity<>(shoppingCartService.convertShoppingCartToShoppingCartResponse(shopping_cart), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        shoppingCartService.delete(id);
        return new ResponseEntity<>("Delete success!",HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll(){
        shoppingCartService.deleteAllProduct();
        return new ResponseEntity<>("Delete success!",HttpStatus.OK);
    }
}
