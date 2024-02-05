package com.ra.controller.admin;

import com.ra.model.dto.response.JwtResponse;
import com.ra.model.entity.User;
import com.ra.service.user_role.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
    //Hiển thị danh sách người dùng phân trang
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5", name = "limit") int limit,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "userName", name = "sort") String sort,
            @RequestParam(defaultValue = "asc", name = "order") String order
    ){
        Pageable pageable;
        if (order.equals("asc")){
            pageable = PageRequest.of(page, limit, Sort.by(sort).ascending());
        }else {
            pageable = PageRequest.of(page, limit, Sort.by(sort).descending());
        }
        Page<JwtResponse> jwtResponses = userService.getAll(pageable);
        return new ResponseEntity<>(jwtResponses, HttpStatus.OK);
    }
    //Thêm mới
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody User user){
        User userNew = userService.save(user);
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }
    //Tìm kiếm người dùng theo tên
    @GetMapping("/search={userName}")
    public ResponseEntity<?> findByName(@PathVariable("userName") String search){
        List<User> users = userService.findByNameUser(search);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //Mở khóa người dùng
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id){
        User user = userService.findById(id);
        if ( user != null){
            user.setStatus(!user.getStatus());
            User userNew = userService.save(user);
            return new ResponseEntity<>(userNew, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    //Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
