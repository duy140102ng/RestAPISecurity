package com.ra.service.user_role;

import com.ra.model.entity.ENUM.UserRole;
import com.ra.model.entity.Role;
import com.ra.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByRoleName(UserRole userRole) {
        Role role = roleRepository.findByRoleName(userRole).orElseThrow(() -> new RuntimeException("role not found"));
        return role;
    }
}
