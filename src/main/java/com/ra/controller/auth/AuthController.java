package com.ra.controller.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.service.user_role.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    //Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> handleLogin(@RequestBody @Valid UserLogin userLogin){
        JwtResponse jwtResponse = userService.handleLogin(userLogin);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
    //Đăng ký
    @PostMapping("/register")
    public ResponseEntity<String> handleRegister(@RequestBody @Valid UserRegister userRegister){
        return new ResponseEntity<>(userService.handleRegister(userRegister), HttpStatus.CREATED);
    }
}
