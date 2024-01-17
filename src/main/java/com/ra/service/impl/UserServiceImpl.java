package com.ra.service.impl;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import com.ra.security.jwt.JwtProvider;
import com.ra.security.user_principal.UserPrincipal;
import com.ra.service.RoleService;
import com.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    //Đăng nhập
    @Override
    public JwtResponse handleLogin(UserLogin userLogin) {
        Authentication authentication;
        try {
            authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassWord()));
        }catch (AuthenticationException exception){
            throw new RuntimeException("userName or password sai");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        //Tạo 1 token
        String token = jwtProvider.generateToken(userPrincipal);
        return JwtResponse.builder().fullName(userPrincipal.getUser().getFullName())
                .id(userPrincipal.getUser().getId()).accessToken(token)
                .role(userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                .build();
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
        return "Register Success";
    }
}
