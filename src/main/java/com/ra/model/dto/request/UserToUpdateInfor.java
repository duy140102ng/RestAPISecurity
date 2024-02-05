package com.ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserToUpdateInfor {
    private String fullName;
    private String Email;
    private String avatar;
    private String phone;
    private String address;
}
