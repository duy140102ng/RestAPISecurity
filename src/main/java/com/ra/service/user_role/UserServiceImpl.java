package com.ra.service.user_role;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.request.UserToUpdateInfor;
import com.ra.model.dto.request.UserToUpdatePassword;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.ENUM.UserRole;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import com.ra.security.jwt.JwtProvider;
import com.ra.security.user_principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
        return JwtResponse.builder()
                .created_at(userPrincipal.getUser().getCreated_at())
                .userName(userPrincipal.getUser().getUserName())
                .email(userPrincipal.getUser().getEmail())
                .status(userPrincipal.getUser().getStatus())
                .phone(userPrincipal.getUser().getPhone())
                .address(userPrincipal.getUser().getAddress())
                .updated_at(userPrincipal.getUser().getUpdated_at())
                .fullName(userPrincipal.getUser().getFullName())
                .id(userPrincipal.getUser().getId())
                .accessToken(token)
                .role(userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public String handleRegister(UserRegister userRegister) {
        if (userRepository.existsByUserName(userRegister.getUserName())){
            throw new RuntimeException("userName is exits");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(UserRole.USER));
        User user = User.builder()
                .fullName(userRegister.getFullName())
                .userName(userRegister.getUserName())
                .passWord(passwordEncoder.encode(userRegister.getPassWord()))
                .email(userRegister.getEmail())
                .status(true)
                .avatar(userRegister.getAvatar())
                .phone(userRegister.getPhone())
                .address(userRegister.getAddress())
                .created_at(userRegister.getCreated_at())
                .updated_at(userRegister.getUpdated_at())
                .roles(roles)
                .build();
        userRepository.save(user);
        return "Register Success";
    }

    @Override
    public Page<JwtResponse> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(item -> JwtResponse.builder()
                .id(item.getId())
                .created_at(item.getCreated_at())
                .userName(item.getUserName())
                .email(item.getEmail())
                .status(item.getStatus())
                .phone(item.getPhone())
                .address(item.getAddress())
                .updated_at(item.getUpdated_at())
                .fullName(item.getFullName())
                .role(item.getRoles().stream().map(role->role.getRoleName().name()).collect(Collectors.toSet()))
                .build());
    }

    @Override
    public List<User> findByNameUser(String search) {
        return userRepository.findByUserNameContaining(search);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User inforLoginAcc() {
        return null;
    }

    @Override
    public JwtResponse displayAccount() {
        return null;
    }

    @Override
    public JwtResponse displayUser(User user) {
        return null;
    }

    @Override
    public JwtResponse displayUserToAdmin(User user) {
        return null;
    }

    @Override
    public User updateInforAcc(UserToUpdateInfor userToUpdateInfor) {
        return null;
    }

    @Override
    public void updatePasswordAcc(UserToUpdatePassword userToUpdatePassword) {

    }
}
