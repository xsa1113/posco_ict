package com.posco.insta.post.repository;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> getPost();
    List<PostDto> getPostById(PostDto postDto); // 내가한거
    List<SelectPostJoinUserDto> findPostsByUserId(PostDto postDto);

    int deletePostByUserIdAndId(PostDto postDto);
}
