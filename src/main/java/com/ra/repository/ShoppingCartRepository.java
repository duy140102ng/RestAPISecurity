package com.ra.repository;

import com.ra.model.entity.Shopping_Cart;
import com.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<Shopping_Cart, Long> {
//    Page<Shopping_Cart> findAllByUser_id(User user, Pageable pageable);
//    Shopping_Cart findByIdAndUser_id(Integer id, User user);
//    void deleteByUser_id(User user);
}
