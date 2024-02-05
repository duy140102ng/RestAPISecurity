package com.ra.model.dto.response;

import com.ra.model.entity.User;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtResponse {
    private Long id;
    private String accessToken;
    private final String type = "Bearer";
    private String fullName;
    private String userName;
    private String email;
    private Boolean status;
    private String avatar;
    private String phone;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Set<String> role;

    public JwtResponse(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }
}
