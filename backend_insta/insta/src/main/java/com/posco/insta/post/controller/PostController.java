package com.posco.insta.post.controller;

import com.posco.insta.aspect.TokenRequired;
import com.posco.insta.config.SecurityService;
import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;
import com.posco.insta.post.service.PostServiceImpl;
import com.posco.insta.user.service.UserServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@TokenRequired
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    PostDto postDto;

    @GetMapping("/")
    public List<PostDto> getPost() {
        return postService.findPost();
    }
    // 내가 한거 -> userid를 받아오지 않는데 밑에코드는 userid를 받아온다
//    @GetMapping("/my")
//    @TokenRequired
//    public List<PostDto> getPostMyPost(){
//        PostDto postDto = new PostDto();
//        postDto.setUserId(String.valueOf(securityService.getIdAtToken()));
//        return postService.findUserById(postDto);
//    }

    @GetMapping("/my")
    public List<SelectPostJoinUserDto> getPostMyPost(){
        PostDto postDto = new PostDto();
        postDto.setUserId(securityService.getIdAtToken());
        return postService.getPostByUserId(postDto);
    }

    //삭제 -> userid에 맞는걸 지우고, 그에 맞는 postid 값도 같이 보내줘서 삭제
    @DeleteMapping("/{id}")
    public boolean deleteMyPost(@PathVariable String id){
        postDto.setId(Integer.valueOf(id));
        postDto.setUserId(securityService.getIdAtToken());

        if(postService.deletePostByUserIdAndId(postDto) == 1){
            //삭제가 완료되었으면
            return true;
        }else{
            return false;
        }
    }

    //수정 -> userid에 맞는걸 수정하고, 그에 맞는 postid 값도 같이 보내줘서 수정



}
