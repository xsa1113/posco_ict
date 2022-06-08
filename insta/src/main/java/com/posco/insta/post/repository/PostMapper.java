package com.posco.insta.post.repository;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> getPost();
    PostDto getUserById(UserDto userDto);
}
