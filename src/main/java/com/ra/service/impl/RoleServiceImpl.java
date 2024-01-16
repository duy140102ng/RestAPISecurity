package com.ra.service.impl;

import com.ra.model.entity.Role;
import com.ra.repository.RoleRepository;
import com.ra.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByRoleName(String roleName) {
        Role role = roleRepository.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("role not found"));
        return role;
    }
}
