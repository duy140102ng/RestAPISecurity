package com.ra.service.user_role;

import com.ra.model.entity.ENUM.UserRole;
import com.ra.model.entity.Role;

public interface RoleService {
    Role findByRoleName (UserRole userRole);
}
