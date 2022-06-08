package com.posco.insta.post.model;

import lombok.Data;

@Data
public class PostDto {
    private String id;
    private String userId;
    private String img;
    private String content;

}
