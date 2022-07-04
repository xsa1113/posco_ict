package com.example.userService.repository;

import com.example.userService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserByUseridAndPassword(String userId, String password);
}
