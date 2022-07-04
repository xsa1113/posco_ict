package com.example.userService.controller;

import com.example.userService.dto.LoginDto;
import com.example.userService.dto.RequestLoginDto;
import com.example.userService.entity.UserEntity;
import com.example.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String check(){
        return "check";
    }

    @GetMapping("/all")
    public List<UserEntity> getUserAll(){
        return userService.getUser();
    }

    @PostMapping("/login")
    public LoginDto login(@RequestBody RequestLoginDto requestLoginDto){
        return userService.getLogin(requestLoginDto);
    }
}
