package com.ra.controller.admin;

import com.ra.model.entity.ENUM.UserRole;
import com.ra.model.entity.Role;
import com.ra.service.user_role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //Lấy dnah sách quyền người dùng
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestBody UserRole userRole){
        Role roles = roleService.findByRoleName(userRole);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
