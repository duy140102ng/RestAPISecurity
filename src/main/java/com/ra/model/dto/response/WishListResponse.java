package com.ra.model.dto.response;

import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import com.ra.model.entity.Wish_List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WishListResponse {
    private Long id;
    private Product product_id;
    private User user_id;
    public WishListResponse(Wish_List wishList){
        this.id = wishList.getId();
        this.product_id = wishList.getProduct_id();
        this.user_id = wishList.getUser_id();
    }
}
