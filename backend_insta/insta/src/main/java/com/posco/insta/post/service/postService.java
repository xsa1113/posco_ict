package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;

import java.util.List;

public interface postService {

    List<PostDto> findPost();
    List<PostDto> findUserById(PostDto postDto); // 내가한거
    List<SelectPostJoinUserDto> getPostByUserId(PostDto postDto);

    int deletePostByUserIdAndId(PostDto postDto);
}
