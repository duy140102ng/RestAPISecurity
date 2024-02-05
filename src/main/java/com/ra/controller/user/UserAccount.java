package com.ra.controller.user;

import com.ra.model.dto.request.UserToUpdateInfor;
import com.ra.model.dto.request.UserToUpdatePassword;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.User;
import com.ra.service.user_role.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/account")
public class UserAccount {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<JwtResponse> displayAccount(){
        JwtResponse jwtResponse = userService.displayAccount();
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<JwtResponse> updateAccount(@RequestBody UserToUpdateInfor userToUpdateInfor){
        User userUpdate = userService.updateInforAcc(userToUpdateInfor);
        return new ResponseEntity<>(userService.displayUser(userUpdate), HttpStatus.OK);
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> updatePasswordAccount(@RequestBody UserToUpdatePassword userToUpdatePassword){
        userService.updatePasswordAcc(userToUpdatePassword);
        return new ResponseEntity<>("password success!",HttpStatus.OK);
    }
}
