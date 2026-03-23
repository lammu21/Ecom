package com.example.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userService.model.User;

public interface UserRepository extends JpaRepository<User,String>
{
  
}
