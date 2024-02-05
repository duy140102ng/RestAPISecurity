package com.ra.model.dto.response;

import com.ra.model.entity.Address;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressResponse {
    private Long id;
    private User user_id;
    private String fullAddress;
    private String phone;
    private String receiveName;
    public AddressResponse(Address address){
        this.id = address.getId();
        this.user_id = address.getUser_id();
        this.fullAddress = address.getFullAddress();
        this.phone = address.getPhone();
        this.receiveName = getReceiveName();
    }
}
