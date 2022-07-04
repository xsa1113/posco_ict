package com.example.userService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    private Integer id;
    private String name;
    private String userid;
    private String password;
    private String img;
}
