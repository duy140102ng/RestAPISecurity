package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private Long sku;
    @Column(unique = true)
    private String productName;
    private String description;
    private Double price;
    private Integer stock_quantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime created_at;
    @PrePersist
    public void setCreatedAt() {
        this.created_at = LocalDateTime.now();
    }
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime updated_at;
    @PreUpdate
    public void setUpdatedAt() {
        this.updated_at = LocalDateTime.now();
    }
    @OneToMany(mappedBy = "product_id")
    @JsonIgnore
    List<OrderDetails> orderDetails;
    @OneToMany(mappedBy = "product_id")
    @JsonIgnore
    List<Shopping_Cart> shoppingCarts;
    @OneToMany(mappedBy = "product_id")
    @JsonIgnore
    List<Wish_List> wishLists;
}
