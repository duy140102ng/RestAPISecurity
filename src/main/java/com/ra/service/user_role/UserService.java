package com.ra.service.user_role;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.request.UserToUpdateInfor;
import com.ra.model.dto.request.UserToUpdatePassword;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    JwtResponse handleLogin(UserLogin userLogin);
    String handleRegister(UserRegister userRegister);
    Page<JwtResponse> getAll(Pageable pageable);
    List<User> findByNameUser(String search);
    User findById(Long id);
    User save(User user);
    void delete(Long id);
    User inforLoginAcc();
    JwtResponse displayAccount();
    JwtResponse displayUser(User user);
    JwtResponse displayUserToAdmin(User user);
    User updateInforAcc(UserToUpdateInfor userToUpdateInfor);
    void updatePasswordAcc(UserToUpdatePassword userToUpdatePassword);
}
