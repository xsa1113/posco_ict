package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.user.model.UserDto;

import java.util.List;

public interface postService {

    List<PostDto> findPost();
    PostDto findUserById(UserDto userDto);
}
