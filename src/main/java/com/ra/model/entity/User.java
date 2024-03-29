package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String userName;
    private String passWord;
    @Column(unique = true)
    private String email;
//    @Column(columnDefinition = "boolean default true")
    private Boolean status = true;
    private String avatar;
    @Column(unique = true)
    private String phone;
    private String address;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    List<Orders> orders;
    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    List<Shopping_Cart> shoppingCarts;
    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    List<Address> addresses;
    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    List<Wish_List> wishLists;
}
