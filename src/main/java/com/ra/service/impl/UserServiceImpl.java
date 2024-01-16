package com.ra.service.impl;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import com.ra.service.IRoleService;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;
    @Override
    public JwtResponse handleLogin(UserLogin userLogin) {
        return null;
    }

    @Override
    public String handleRegister(UserRegister userRegister) {
        if (userRepository.existsByUserName(userRegister.getUserName())){
            throw new RuntimeException("userName is exits");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));
        User user = User.builder()
                .fullName(userRegister.getFullName())
                .userName(userRegister.getUserName())
                .passWord(passwordEncoder.encode(userRegister.getPassWord()))
                .status(true)
                .roles(roles)
                .build();
        userRepository.save(user);
        return "Success";
    }
}
