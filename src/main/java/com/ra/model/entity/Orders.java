package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.model.entity.ENUM.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serial_number;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;
    private Double total_price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String note;
    private String receive_name;
    private String receive_address;
    private String receive_phone;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime created_at;
    @PrePersist
    public void setCreatedAt() {
        this.created_at = LocalDateTime.now();
    }
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime receive_at;
    @PreUpdate
    public void setReceiveAt() {
        this.receive_at = LocalDateTime.now().plusDays(4);
    }
    @OneToMany(mappedBy = "order_id")
    @JsonIgnore
    List<OrderDetails> orderDetails;
}
