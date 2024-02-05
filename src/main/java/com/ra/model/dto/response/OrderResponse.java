package com.ra.model.dto.response;

import com.ra.model.entity.ENUM.OrderStatus;
import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponse {
    private Long id;
    private String serial_number;
    private User user;
    private Double total_price;
    private OrderStatus status;
    private String note;
    private String receive_name;
    private String receive_address;
    private String receive_phone;
    private LocalDateTime created_at;
    private LocalDateTime receive_at;
    public OrderResponse(Orders orders){
        this.id = orders.getId();
        this.serial_number = orders.getSerial_number();
        this.user = orders.getUser_id();
        this.total_price = orders.getTotal_price();
        this.status = orders.getStatus();
        this.note = orders.getNote();
        this.receive_name = orders.getReceive_name();
        this.receive_address = orders.getReceive_address();
        this.receive_phone = orders.getReceive_phone();
        this.created_at = orders.getCreated_at();
        this.receive_at = orders.getReceive_at();
    }
}
