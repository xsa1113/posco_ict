package com.posco.insta.post.controller;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.user.model.UserDto;
import com.posco.insta.post.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/")
    public List<PostDto> getPost() {
        return postService.findPost();
    }

    @GetMapping("/{id}")
    public PostDto getUser(@PathVariable String id){
        UserDto userDto = new UserDto();
        userDto.setId(Integer.valueOf(id));
        return postService.findUserById(userDto);
    }



}
