package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.user.model.UserDto;
import com.posco.insta.post.repository.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements postService{
    @Autowired
    PostMapper postMapper;


    @Override
    public List<PostDto> findPost() {
        return postMapper.getPost();
    }

    @Override
    public PostDto findUserById(UserDto userDto) {
        return postMapper.getUserById(userDto);
    }
}
