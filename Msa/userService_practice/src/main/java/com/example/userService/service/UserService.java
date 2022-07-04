package com.example.userService.service;

import com.example.userService.dto.LoginDto;
import com.example.userService.dto.RequestLoginDto;
import com.example.userService.entity.UserEntity;
import com.example.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    public LoginDto getLogin(RequestLoginDto requestLoginDto){
        UserEntity loginUser = userRepository.findUserByUseridAndPassword(requestLoginDto.getUserId(), requestLoginDto.getPassword());
        return  LoginDto.builder()
                .img(loginUser.getImg())
                .name(loginUser.getName())
                .token("asdfasd")
                .build();
    }
}
