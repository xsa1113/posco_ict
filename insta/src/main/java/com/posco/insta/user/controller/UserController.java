package com.posco.insta.user.controller;

import com.posco.insta.config.SecurityService;
import com.posco.insta.user.model.UserDto;
import com.posco.insta.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    SecurityService securityService;

    @GetMapping("/")
    public List<UserDto> getUser() {
        return userService.findUser();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        UserDto userDto = new UserDto();
        userDto.setId(Integer.valueOf(id));
        return userService.findUserById(userDto);
    }

    @PostMapping("/")
    public int createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable String id){
        UserDto userDto = new UserDto();
        userDto.setId(Integer.valueOf(id));
        return userService.deleteUser(userDto);
    }

    @PutMapping("/{id}")
    public Integer updateUserById(@RequestBody UserDto userDto, @PathVariable String id){
        userDto.setId(Integer.valueOf(id));
        return userService.updateUserById(userDto);
    }

    @PostMapping("/login")
    public Map loginUser(@RequestBody UserDto userDto){
        UserDto loginUser = userService.serviceLogin(userDto);
        // 밀리초
        String token = securityService.createToken(loginUser.getId().toString(),    3 * 24 * 60 * 60 * 1000);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("name", loginUser.getName());
        map.put("img", loginUser.getImg());

        return map;
    }

    @GetMapping("/token")
    public String getToken(@RequestParam(value = "token") String token){
        String subject = securityService.getSubject(token);
        return subject;
    }

}
